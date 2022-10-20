package com.shebogholo.springbootdocker.auth;

import com.shebogholo.springbootdocker.user.User;
import com.shebogholo.springbootdocker.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // register
    public String register(RegisterRequest registerRequest) {
        // check valid email format
        if (!registerRequest.email().matches("^(.+)@(.+).$")){
            throw new IllegalStateException("Email is not valid");
        }

        // check if password has at least 6 characters, one number, one special character, one uppercase letter
        if (registerRequest.password().length() < 6 || !registerRequest.password().matches(".*\\d.*") || !registerRequest.password().matches(".*[!@#$%^&*()_+].*") || !registerRequest.password().matches(".*[A-Z].*")){
            throw new IllegalStateException("Password is not valid");
        }

        // check if user is in database
        boolean userExists = userRepository
                .findByEmail(registerRequest.email())
                .isPresent();
        if (userExists){
            throw new IllegalStateException("Email already taken");
        }

        String encodedPassword = passwordEncoder.encode(registerRequest.password());
        User user = User.builder()
                .firstName(registerRequest.firstName())
                .lastName(registerRequest.lastName())
                .email(registerRequest.email())
                .password(encodedPassword)
                .build();

        // Store user to DB
        userRepository.save(user);
        return "User registered successfully!";
    }

    // function to authorize user
    public Optional<User> login(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByEmail(loginRequest.email());
        if (user.isPresent()) {
            if (passwordEncoder.matches(loginRequest.password(), user.get().getPassword())) {
                // generate token
                return user;
            }
        }
        return user;
    }

}

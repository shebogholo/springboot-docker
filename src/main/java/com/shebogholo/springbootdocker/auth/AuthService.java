package com.shebogholo.springbootdocker.auth;

import com.shebogholo.springbootdocker.user.User;
import com.shebogholo.springbootdocker.user.UserRepository;
import com.shebogholo.springbootdocker.utils.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    // register
    public String register(RegisterRequest registerRequest) {
        User user = User.builder()
                .firstName(registerRequest.firstName())
                .lastName(registerRequest.lastName())
                .email(registerRequest.email())
                .password(this.passwordService.passwordEncoder().encode(registerRequest.password()))
                .build();
        // todo: Check if email is valid


        // Check if email is not taken
        if (userRepository.existsByEmail(user.getEmail())){
            return "This email already exist!";
        }else {
            // Store user to DB
            userRepository.save(user);
            return "User registered successfully!";
        }
    }

    // function to authorize user
    public Optional<User> login(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByEmail(loginRequest.email());
        if (user.isPresent()) {
            if (this.passwordService.passwordEncoder().matches(loginRequest.password(), user.get().getPassword())) {
                // generate token
                return user;
            }
        }
        return user;
    }

}

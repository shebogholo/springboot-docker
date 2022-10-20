package com.shebogholo.springbootdocker.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            User user = User.builder()
                    .firstName("Waziri")
                    .lastName("Shebogholo")
                    .email("shebogholo@gmail.com")
                    .password(passwordEncoder.encode("68jhGdj@.ld"))
                    .build();

            // check if user is in database
            if (!userRepository.existsByEmail(user.getEmail())){
                // insert users to database
                userRepository.save(user);
            }
        };
    }
}
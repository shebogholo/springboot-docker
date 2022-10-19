package com.shebogholo.springbootdocker.user;

import com.shebogholo.springbootdocker.utils.PasswordService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    // Populate users table
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordService passwordService){
        return args -> {
            User user = User.builder()
                    .firstName("Waziri")
                    .lastName("Shebogholo")
                    .email("shebogholo@gmail.com")
                    .password(passwordService.passwordEncoder().encode("68jhGdj@.ld"))
                    .build();
            // check if user is in database
            if (!userRepository.existsByEmail(user.getEmail())){
                // insert users to database
                userRepository.save(user);
            }

        };
    }
}
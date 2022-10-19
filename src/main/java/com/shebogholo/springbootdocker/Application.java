package com.shebogholo.springbootdocker;

import lombok.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    public Message index() {
        return Message.builder().message("API is up and running on a Docker!").build();
    }

    @Builder
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Message {
        private String message;
    }

    @Bean
    ApplicationRunner init(){
        return args -> {
            System.out.println("**************************  Application is up and running **********************");
        };
    }

}

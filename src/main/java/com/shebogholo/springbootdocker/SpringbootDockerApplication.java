package com.shebogholo.springbootdocker;

import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDockerApplication.class, args);
    }

    // index page
    @RequestMapping("/")
    public Message index() {
        return Message.builder().message("Greetings from Spring Boot!").build();
    }

    @Builder
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Message {
        private String message;
    }

}

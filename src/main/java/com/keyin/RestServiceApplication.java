package com.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.keyin.user")
public class RestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }
}

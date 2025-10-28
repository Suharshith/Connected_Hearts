package com.marriagebureau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:3000")
public class MarriageBureauApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarriageBureauApplication.class, args);
    }
}

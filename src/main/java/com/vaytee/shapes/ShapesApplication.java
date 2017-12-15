package com.vaytee.shapes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ShapesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShapesApplication.class, args);
    }
}

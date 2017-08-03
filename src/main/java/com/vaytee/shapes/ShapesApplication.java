package com.vaytee.shapes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@ComponentScan
@EnableMongoRepositories
public class ShapesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShapesApplication.class, args);
    }
}

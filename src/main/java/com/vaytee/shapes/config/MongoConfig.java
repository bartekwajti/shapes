package com.vaytee.shapes.config;

import com.vaytee.shapes.security.SecurityAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Admin on 2017-07-30.
 */
@Configuration
@EnableMongoAuditing
@EnableMongoRepositories
public class MongoConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new SecurityAuditorAware();
    }
}

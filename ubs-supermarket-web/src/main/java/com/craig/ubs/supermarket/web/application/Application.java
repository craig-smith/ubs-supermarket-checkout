package com.craig.ubs.supermarket.web.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.craig.ubs.supermarket")
@EnableJpaRepositories(basePackages = "com.craig.ubs.supermarket.core.repository")
@EntityScan(basePackages = "com.craig.ubs.supermarket.core.data")
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public DataGenerator generateSampleData() {
        return new DataGenerator();
    }
}

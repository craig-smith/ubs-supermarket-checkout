package com.craig.ubs.supermarket.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.craig.ubs.supermarket.cor")
public class TestApplication {

    public static void maain(String args[]) {
        SpringApplication.run(TestApplication.class, args);
    }
}

package com.dynamic.urls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Application class
 * 
 * @author BharatGoel
 *
 */
@SpringBootApplication
@ComponentScan("com.dynamic.urls")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
package com.vanhieu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        System.out.println("hello Gradle - hello");
        SpringApplication.run(HelloWorldApplication.class, args);
    }

}

package com.jenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloJenkinsApplication {

    public static void main(String[] args) {

        SpringApplication.run(HelloJenkinsApplication.class, args);
        System.out.println("Greetings Workshop!");
        System.out.println("This is an example file");
        System.out.println("for use in workshop exercises.");
        System.out.println("This is on the master branch");
        System.out.println("This file is written in Java.");
        System.out.println("Isn't this exciting?");
        System.out.println("Maybe?");
        System.out.println("Okay then.");
        System.out.println("Goodbye Workshop!");
    }

}

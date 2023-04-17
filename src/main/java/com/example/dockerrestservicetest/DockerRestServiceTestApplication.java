package com.example.dockerrestservicetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerRestServiceTestApplication {

    public static void main(String[] args) {
        System.out.println("Hello");
        SpringApplication.run(DockerRestServiceTestApplication.class, args);
    }

}

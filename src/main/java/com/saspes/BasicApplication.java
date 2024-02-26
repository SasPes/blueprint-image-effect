package com.saspes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicApplication {

    public static void main(String[] args) {
        nu.pattern.OpenCV.loadLocally();
        SpringApplication.run(BasicApplication.class, args);
    }
}

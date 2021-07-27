package com.learning.edu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LearningEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearningEurekaApplication.class,args);
    }
}

package com.learning.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.learning.edu")
public class LearningFrontApplication {
    public static void main(String[] args){
        SpringApplication.run(LearningFrontApplication.class,args);
    }
}

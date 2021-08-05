package com.learning.edu.ad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //use as client of eureka
@MapperScan("com.learning.edu.ad.mapper") //integrate mybatis and springboot, tell springboot
public class LearningAdApplication {
    public static void main(String[] args){
        SpringApplication.run(LearningAdApplication.class, args);
    }
}

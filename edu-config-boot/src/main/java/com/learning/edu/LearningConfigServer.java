package com.learning.edu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LearningConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(LearningConfigServer.class,args);
    }
}

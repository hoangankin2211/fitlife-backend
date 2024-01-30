package com.fitlife.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FitlifeEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(FitlifeEurekaApplication.class, args);
    }
}

package com.ysstech.demo.user;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2Doc
@SpringBootApplication
public class DemoUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoUserApplication.class, args);
    }

}

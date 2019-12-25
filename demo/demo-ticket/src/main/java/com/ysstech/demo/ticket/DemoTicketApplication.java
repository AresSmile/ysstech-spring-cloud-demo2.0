package com.ysstech.demo.ticket;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableSwagger2Doc
@SpringBootApplication
@MapperScan("com.ysstech.demo.ticket.mapper")
public class DemoTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTicketApplication.class, args);
    }

}

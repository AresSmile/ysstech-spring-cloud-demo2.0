package com.ysstech.demo.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
/*
 * @Author huangyuan
 * @Description //熔断仪表盘 17:51
 * @Date 17:51 2019/12/9
 * @Param
 * @returnType
 **/
@EnableDiscoveryClient
@EnableHystrixDashboard //熔断器仪表盘
@SpringBootApplication
public class DemoHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHystrixDashboardApplication.class, args);
    }

}

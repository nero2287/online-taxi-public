package com.taxi.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServicePassengerUserApplication {
    public static void main(String[] args){
        SpringApplication.run(ServicePassengerUserApplication.class,args);
        System.out.println("乘客数据端已启动：8030");
    }
}

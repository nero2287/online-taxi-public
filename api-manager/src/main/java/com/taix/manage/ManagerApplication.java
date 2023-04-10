package com.taix.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ManagerApplication {
    public static void main(String[] args){
        SpringApplication.run(ManagerApplication.class,args);
        System.out.println("管理员服务端口8070已启动");
    }
}

package com.taix.verification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VerificationApplication {
    public static void main(String[] args){
        SpringApplication.run(VerificationApplication.class);
        System.out.println("验证码服务8020已启动");
    }
}

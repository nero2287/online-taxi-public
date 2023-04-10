package com.taxi.price;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.taxi.price.mapper")
public class ServicePriceApplication {
    public static void main(String[] args){
        SpringApplication.run(ServicePriceApplication.class);
        System.out.println("计价服务端口：8050已启动");
    }
}

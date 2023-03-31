package com.taix.map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@FeignClient
public class ServiceMapApplication {
    public static void main(String[] args){
        SpringApplication.run(ServiceMapApplication.class);
        System.out.println("地图服务端口：8040已启动");
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

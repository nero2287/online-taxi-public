package com.taxi.driver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.taxi.driver.mapper")
public class DriverUserApplication {
    public static void main(String[] args){
        SpringApplication.run(DriverUserApplication.class,args);
        System.out.println("驾驶员服务已启动端口：8060");
    }
}

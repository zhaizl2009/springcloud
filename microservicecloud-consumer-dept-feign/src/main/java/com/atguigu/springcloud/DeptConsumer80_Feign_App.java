package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author zzl
 * @date 2019/7/14 0014- 21:06
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages={"com.atguigu.springcloud"})
//@ComponentScan("com.atguigu.springcloud")
public class DeptConsumer80_Feign_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_App.class,args);
        System.out.println("Feign启动成功");
    }
}

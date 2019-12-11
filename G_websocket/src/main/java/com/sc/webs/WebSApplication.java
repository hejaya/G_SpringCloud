package com.sc.webs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/8/18 11:11
 **/
@EnableEurekaClient
@SpringBootApplication
public class WebSApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSApplication.class);
    }
}

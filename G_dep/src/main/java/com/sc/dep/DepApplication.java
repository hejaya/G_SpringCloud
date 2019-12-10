package com.sc.dep;

import com.sc.common.utils.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/29 15:52
 **/
//@EnableEurekaClient
@SpringBootApplication
@MapperScan(value = "com.sc.dep.dao")
public class DepApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepApplication.class);
    }

    @Bean
    public IdWorker idWorkker(){
        return new IdWorker(1, 1);
    }
}

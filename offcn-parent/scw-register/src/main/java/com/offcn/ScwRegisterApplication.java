package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by travelround on 2020/6/2.
 */

@SpringBootApplication
@EnableEurekaServer  //开启EurekaServer注册中心服务器
public class ScwRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScwRegisterApplication.class, args);
    }

}


package com.zhangqiqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringCloudConfigApp.class, args);
    }
}

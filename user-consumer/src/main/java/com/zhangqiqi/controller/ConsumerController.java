package com.zhangqiqi.controller;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.zhangqiqi.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService service;

    @GetMapping("/")
    public String get(Long id){
        System.out.println("消费端");
        //客户端for循环1万次请求服务端
            service.get(1l);
        return "Consumer成功了";
    }

}

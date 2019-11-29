package com.zhangqiqi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service")
public interface ConsumerService {
    @GetMapping("/user/get/{id}")
    String get(@PathVariable("id") Long id);
}

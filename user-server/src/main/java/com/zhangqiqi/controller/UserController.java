package com.zhangqiqi.controller;


import com.zhangqiqi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

   /* @RequestMapping("getList")
    public List<User> getList(){
        List<User> list = service.getList();
        return list;
    }*/

    @GetMapping("/user/get/{id}")
    public String get(@PathVariable("id")Long id){
        System.out.println("接受的参数"+id);
        return "Producer Server port:";
    }


}

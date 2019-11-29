package com.zhangqiqi.test;

import com.zhangqiqi.dao.UserCrudRepository;
import com.zhangqiqi.dao.UserPagingAndSortingRepository;
import com.zhangqiqi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserPagingAndSortingRepositoryTest {
    @Autowired
    UserPagingAndSortingRepository userPagingAndSortingRepository;
    @Autowired
    UserCrudRepository userCrudRepository;
    //分页
    @Test
    public void findAll(){
        Pageable pageable = PageRequest.of(0,2);
        Page<User> page = userPagingAndSortingRepository.findAll(pageable);
        System.out.println("总页数："+page.getTotalPages());
        System.out.println("总条数："+page.getTotalElements());
        System.out.println("数据："+page.getContent());
    }
    //排序
   @Test
    public void findAllSort(){
        Iterable<User> users = userCrudRepository.findAll();
        System.out.println(users);

    }

    //分页排序一起使用
    /* @Test
    public void findAllPageAndSort(){
        Sort sort = new Sort(Sort.Direction.DESC, "username");
        Pageable pageable  = PageRequest.of(0, 2,sort);
        Page<User> page = userCrudRepository.findAll(pageable);
        System.out.println("总页数："+page.getTotalPages());
        System.out.println("总条数："+page.getTotalElements());
        System.out.println("数据："+page.getContent());

    }*/

}

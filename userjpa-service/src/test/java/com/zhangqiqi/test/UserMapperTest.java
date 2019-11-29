package com.zhangqiqi.test;

import com.zhangqiqi.entity.User;
import com.zhangqiqi.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper mapper;
    //单条件查询
    @Test
    public void findByCreated(){
        List<User> list = mapper.findByCreated(new Date());
        System.out.println("查询:"+list);
    }
    //多条件查询
    @Test
    public void findByCreatedAndUsernameNot(){
        List<User> list = mapper.findByCreatedAndUsernameNot(new Date(),"laogao");
        System.out.println("查询:"+list);
    }
    //模糊查询
    @Test
    public void findByUsernameLike(){
        List<User> list = mapper.findByUsernameLike("l");
        System.out.println("查询:"+list);
    }
    //使用原生sql语句查询
    @Test
    public void selectById(){
        User user = mapper.selectById(1l);
        System.out.println("查询:"+user);
    }
    //根据时间查询并且按时间排序
    @Test
    public void findByCreatedSort(){
        Sort sort = new Sort(Sort.Direction.DESC,"created");
        List<User> userList = mapper.findByCreatedSort(new Date(), sort);
        System.out.println("查询:"+userList);
    }


    @Test
    public void findByCreated1(){
        Pageable pageable  = PageRequest.of(0, 2);
        Page<User> page = mapper.findByCreated(new Date(),pageable);
        System.out.println("查询:"+page);
    }


}

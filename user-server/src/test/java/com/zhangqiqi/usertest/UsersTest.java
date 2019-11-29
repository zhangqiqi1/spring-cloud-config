package com.zhangqiqi.usertest;

import com.zhangqiqi.entity.User;
import com.zhangqiqi.entity.UserExample;
import com.zhangqiqi.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsersTest {
    @Autowired
    UserMapper mapper;

    @Test
    public void usertest(){
        System.out.println("ssss");
      /*  UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(1);
        criteria.andNameEqualTo("张三");
        List<User> users = mapper.selectByExample(example);
        System.out.println("查询的数据为:"+users);*/
    }
}

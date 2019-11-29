package com.zhangqiqi.test;

import com.zhangqiqi.dao.UserCrudRepository;
import com.zhangqiqi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCrudRepositoryTest {
    @Autowired
    UserCrudRepository userCrudRepository;

    @Test
    public void findAll(){
        Iterable<User> users = userCrudRepository.findAll();
        System.out.println(users);
    }
    @Test
    public void findById(){
        Optional<User> optional = userCrudRepository.findById(1L);
        User user = optional.get();
        System.out.println(user);
    }

    @Test
    public void save(){
        User user= new User();
        user.setUsername("laogao");
        user.setPhone("13611064315");
        user.setPassword("123456");
        user.setSalt("123");
        user.setCreated(new Date());
        User user1 = userCrudRepository.save(user);
        System.out.println(user1);
    }

    @Test
    public void update(){
        User user= new User();
        user.setId(33L);
        user.setUsername("wangwu");
        user.setPhone("13611064316");
        user.setPassword("123456");
        user.setSalt("123");
        user.setCreated(new Date());
        User user1 = userCrudRepository.save(user);
        System.out.println(user1);
    }

    @Test
    public void delete(){
        User user= new User();
        user.setId(33L);
        userCrudRepository.delete(user);
    }

    @Test
    public void findUserByUsername() {
        List<User> users = userCrudRepository.findUserByUsername("jianganming");
        System.out.println(users);
    }


}
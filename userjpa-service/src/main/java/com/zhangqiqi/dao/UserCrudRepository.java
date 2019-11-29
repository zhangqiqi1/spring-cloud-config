package com.zhangqiqi.dao;


import com.zhangqiqi.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<User,Long> {
        public List<User> findUserByUsername(String str);
}
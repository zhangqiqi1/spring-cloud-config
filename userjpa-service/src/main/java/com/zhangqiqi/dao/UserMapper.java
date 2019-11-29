package com.zhangqiqi.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.zhangqiqi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface UserMapper extends Repository<User,Long> {
    //单条件查询
    @Query("select u from User u where u.created < ?1")
    List<User> findByCreated(Date date);
    //多条件查询
    @Query("select u from User u where u.created < ?1 and u.username <> ?2")
    List<User> findByCreatedAndUsernameNot(Date date,String username);
    //模糊查询
/*    @Query("select u from User u where u.username like %?1%")
    List<User> findByUsernameLike(String username);*/
    @Query("select u from User u where u.username like %?1%")
    List<User> findByUsernameLike(String username);

    //使用原生sql查询
    @Query(value = "select * from tb_user where id=?", nativeQuery = true)
    User selectById(Long id);
    //根据时间查询并且按时间排序
    @Query("select u from User u where u.created < ?1")
    List<User> findByCreatedSort(Date date, Sort sort);
    //
    @Query("select u.id,u.username,length(u.username) as username_len from User u")
    List<Object[]> findUsernameLenBySort(Sort sort);
    //query分页
    @Query("select u from User u where u.created < ?1")
    Page<User> findByCreated(Date date, Pageable pageable);

    @Query("select u from User u where u.username= :name and u.password = :password")
    User findByUsernameAndPassword(@Param("name") String username, @Param("password") String password);

    @Modifying
    @Query("update User u set u.username = :newName where u.username = :oldName")
    @Transactional
    int updateUsername(@Param("oldName") String oldName,@Param("newName") String newName);
}

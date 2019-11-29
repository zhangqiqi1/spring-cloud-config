package com.zhangqiqi.dao;

import com.zhangqiqi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserDao {

    @Autowired
    private EntityManager entityManager;

    public List<User> findAll(){
        Query query = entityManager.createQuery("FROM User u");
        List resultList = query.getResultList();
        return resultList;
    }

    public User findById(Long id){
        return entityManager.find(User.class,id);
    }

    public List<User> findNameLike(String str){
        String jpql = "FROM User u WHERE u.username like :username";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("username","%"+str+"%");
        List resultList = query.getResultList();
        return resultList;
    }

    public Object[] nativeQueryById(Long id){
        String sql = "select * from tb_user where id = ?";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1,id);
        return (Object[])query.getSingleResult();

    }


    @Transactional
    public User save(User user){
        return  entityManager.merge(user);
    }

    /**
     * 1.remove方法只能移除执久化对象，不能删除游离对象 即删除的对象必须是通过jpa查询出来的对象
     * 2.jpa查询出来的对象必须和remove方法是在一个事务下完成，否则报错
     * @param id
     */
    @Transactional
    public void delete(Long id){
        User user = findById(id);
        entityManager.remove(user);
    }
}
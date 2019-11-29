package com.zhangqiqi.entity;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="tb_user")
public class User implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        // 用户名
        private String username;

        // 密码
        private String password;

        // 电话
        private String phone;

        // 盐
        private String salt;


        // 创建时间
        private Date created;




}


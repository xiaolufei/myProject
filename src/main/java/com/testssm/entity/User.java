package com.testssm.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/21.
 */
public class User implements Serializable {
    /*** id*/
    private Integer id ;
    /*** 用户姓名*/
    private String username ;
    /*** 用户登录密码*/
    private String password ;
    /*** 描述*/
    private String description ;
    /*** 年龄*/
    private Integer age ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", age=" + age +
                '}';
    }
}
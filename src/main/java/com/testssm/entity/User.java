package com.testssm.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/21.
 */
public class User implements Serializable {
    /*** id*/
    private String id ;
    /*** 用户姓名*/
    private String userName ;
    /*** 用户登录密码*/
    private String passWord ;
    /*** 描述*/
    private String description ;
    /*** 年龄*/
    private Integer age ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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
                ", username='" + userName + '\'' +
                ", password='" + passWord + '\'' +
                ", description='" + description + '\'' +
                ", age=" + age +
                '}';
    }
}
package com.hhy.kafkademo.pojos;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.hhy.kafkademo.pojos
 * @Date 2023/10/30 15:16
 * @return
 * @Version 1.0
 */
public class User {
    private String userName;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}

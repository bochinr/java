package com.javaee.ex06.po;

public class User {
    private String userName;
    private int age;
    private String mobile;
    public User(String userName, int age, String mobile) {
        this.userName = userName;
        this.age = age;
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public String getMobile() {
        return mobile;
    }
}

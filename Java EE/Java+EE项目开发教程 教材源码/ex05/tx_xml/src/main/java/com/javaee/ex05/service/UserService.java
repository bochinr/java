package com.javaee.ex05.service;

import com.javaee.ex05.mapper.UserMapper;
import com.javaee.ex05.mapper.UserRoleMapper;
import com.javaee.ex05.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    public void addUser(User user, int roleId){
        userMapper.insertUser(user);
        System.out.println(user.getUserId());
        int n = 1 / 0;
        userRoleMapper.insertUserRole(user.getUserId(), roleId);
    }
}

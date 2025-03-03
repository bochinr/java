package com.javaee.ex03.mapper;

import com.javaee.ex03.po.User;

public interface UserMapper {
    User findUserByUserId(int userId);
    User findUserByUserIdEx(int userId);
}

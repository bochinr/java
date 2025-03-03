package com.javaee.ex11.mapper;

import com.javaee.ex11.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findUserByLoginName(String loginName);
    User findUserByUserId(int userId);
    List<User> findUsers();
    int addUser(User user);
    int deleteUserByUserId(int userId);
    int updateUser(User user);
    int updatePassword(User user);
    int resetPassword(int userId);
    int findUserIdByLoginName(String loginName);
}

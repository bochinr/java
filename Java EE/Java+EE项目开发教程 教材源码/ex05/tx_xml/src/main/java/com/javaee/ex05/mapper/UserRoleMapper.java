package com.javaee.ex05.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    int insertUserRole(@Param("userId") int userId, @Param("roleId") int roleId);
}

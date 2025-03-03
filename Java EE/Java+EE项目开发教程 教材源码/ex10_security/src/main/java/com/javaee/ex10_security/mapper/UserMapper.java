package com.javaee.ex10_security.mapper;

import com.javaee.ex10_security.po.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    SysUser findUserByLoginName(String loginName);
}

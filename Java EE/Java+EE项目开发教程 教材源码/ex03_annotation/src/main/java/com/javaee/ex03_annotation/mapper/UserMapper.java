package com.javaee.ex03_annotation.mapper;

import com.javaee.ex03_annotation.po.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where user_id=#{value};")
    @Results({@Result(property = "userId",column = "user_id"),
            @Result(property = "bookList",column = "user_id", many = @Many(select=
                    "com.javaee.ex03_annotation.mapper.BookMapper.findBookByUserId"))})
    User findUserByUserId(int userId);
}

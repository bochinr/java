package com.javaee.ex03_annotation.mapper;

import com.javaee.ex03_annotation.po.Publisher;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PublisherMapper {
    @Select("select * from publisher where pub_id=#{value};")
    @Results({/*@Result(property = "pubId", column = "pub_id"),*/
            @Result(property = "bookList", column = "pub_id",
                    many = @Many(select=
                            "com.javaee.ex03_annotation.mapper.BookMapper.findBookByPubId"))})
    Publisher findPublisherByPubId(int pubId);

}

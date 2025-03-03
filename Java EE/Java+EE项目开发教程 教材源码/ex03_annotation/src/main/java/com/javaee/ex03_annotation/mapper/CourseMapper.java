package com.javaee.ex03_annotation.mapper;

import com.javaee.ex03_annotation.po.Course;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface CourseMapper {
    @Select("select * from course where course_id=#{value}")
    @Results({@Result(property = "bookId", column = "book_id"),
            @Result(property = "book",column = "book_id",one=@One(select =
                    "com.javaee.ex03_annotation.mapper.BookMapper.findBookByBookId"))})
    Course findCourseByCourseId(int courseId);
}

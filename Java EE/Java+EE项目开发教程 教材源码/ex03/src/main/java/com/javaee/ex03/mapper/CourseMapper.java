package com.javaee.ex03.mapper;
import com.javaee.ex03.po.Course;
public interface CourseMapper {
    Course findCourseByCourseId(int courseId);
    Course findCourseByCourseIdEx(int courseId);
}

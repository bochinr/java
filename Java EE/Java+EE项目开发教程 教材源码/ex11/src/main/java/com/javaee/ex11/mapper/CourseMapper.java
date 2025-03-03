package com.javaee.ex11.mapper;

import com.javaee.ex11.po.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    int addCourse(Course course);
    int editCourse(Course course);
    int deleteCourse(int courseId);
    List<Course> findCourses();
    Course findCourseByCourseId(int courseId);
}

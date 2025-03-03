package com.javaee.ex11.controller;

import com.javaee.ex11.mapper.BookMapper;
import com.javaee.ex11.mapper.CourseMapper;
import com.javaee.ex11.po.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/save_course")
    public String saveCourse(Course course){
        if (course.getCourseId() > 0)
            courseMapper.editCourse(course);
        else
            courseMapper.addCourse(course);
        return "forward:/to_home_page?page=1&homePage=2";
    }

    @RequestMapping("/to_edit_course")
    @ResponseBody
    public Course toEditCourse(int courseId){
        return courseMapper.findCourseByCourseId(courseId);
    }

    @RequestMapping("/delete_course")
    @ResponseBody
    public String deleteCourse(int courseId){
        int count = bookMapper.findBookCountByCourseId(courseId);
        if (count > 0)  // 如果课程信息与其他信息存在外键约束，不能删除
            return "FAIL";
        int res = courseMapper.deleteCourse(courseId);
        return res > 0 ? "SUCCESS" : "FAIL";
    }
}

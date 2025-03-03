package com.javaee.ex04;

import com.javaee.ex04.config.AppConfig;
import com.javaee.ex04.service.ClassService;
import com.javaee.ex04.service.StudentService;
import com.javaee.ex04.service.TeacherService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationScopeTest {
    @Test
    public void xmlScopeTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);;
        ClassService classService1 = ac.getBean(ClassService.class);
        ClassService classService2 = ac.getBean(ClassService.class);
        TeacherService teacherService1 = ac.getBean(TeacherService.class);
        TeacherService teacherService2 = ac.getBean(TeacherService.class);
        StudentService studentService1 = ac.getBean(StudentService.class);
        StudentService studentService2 = ac.getBean(StudentService.class);
        System.out.println("classService1:" + classService1);
        System.out.println("classService2:" + classService2);
        System.out.println("teacherService1:" + teacherService1);
        System.out.println("teacherService2:" + teacherService2);
        System.out.println("studentService1:" + studentService1);
        System.out.println("studentService2:" + studentService2);
        System.out.println("teacherService1.classService：" + teacherService1.getClassService());
        System.out.println("teacherService2.classService：" + teacherService2.getClassService());
        System.out.println("studentService1.classService:" + studentService1.getClassService());
        System.out.println("studentService2.classService:" + studentService2.getClassService());
    }
}

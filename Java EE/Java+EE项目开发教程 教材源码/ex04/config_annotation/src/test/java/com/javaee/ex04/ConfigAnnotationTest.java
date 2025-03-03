package com.javaee.ex04;

import com.javaee.ex04.config.AppConfig;
import com.javaee.ex04.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigAnnotationTest {
    @Test
    public void configAnnotationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService studentService = ac.getBean(StudentService.class);
        System.out.println(studentService.toString());
    }

}

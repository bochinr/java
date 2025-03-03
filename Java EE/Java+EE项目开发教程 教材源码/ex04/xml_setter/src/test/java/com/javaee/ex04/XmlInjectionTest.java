package com.javaee.ex04;

import com.javaee.ex04.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlInjectionTest {
    @Test
    public void xmlInjectionTest(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("config/beans.xml");
        StudentService studentService = ac.getBean(StudentService.class);
        System.out.println(studentService);
    }
}

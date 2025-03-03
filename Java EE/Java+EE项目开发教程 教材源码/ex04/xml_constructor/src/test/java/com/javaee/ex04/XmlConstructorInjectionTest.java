package com.javaee.ex04;

import com.javaee.ex04.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConstructorInjectionTest {
    @Test
    public void xmlConstructorInjectionTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/beans.xml");
        StudentService studentService = ac.getBean(StudentService.class);
        System.out.println(studentService);
    }

}

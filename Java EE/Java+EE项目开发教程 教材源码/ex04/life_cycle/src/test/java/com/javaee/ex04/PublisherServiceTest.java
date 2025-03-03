package com.javaee.ex04;

import com.javaee.ex04.service.PublisherService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PublisherServiceTest {
    @Test
    public void publisherServiceTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/beans.xml");
        PublisherService publisherService = ac.getBean(PublisherService.class);
        AbstractApplicationContext abstractAC = (AbstractApplicationContext)ac;
        abstractAC.registerShutdownHook();
    }

}

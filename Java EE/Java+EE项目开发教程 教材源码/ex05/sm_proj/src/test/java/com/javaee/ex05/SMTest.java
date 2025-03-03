package com.javaee.ex05;

import com.javaee.ex05.mapper.PublisherMapper;
import com.javaee.ex05.po.Publisher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SMTest {
    @Test
    public void smTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/beans.xml");
        PublisherMapper publisherMapper = ac.getBean(PublisherMapper.class);
        List<Publisher> publishers = publisherMapper.findAllPublishers();
        System.out.println(publishers);
    }

}

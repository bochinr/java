package com.javeee.ex05;

import com.javaee.ex05.service.BookService;
import com.javaee.ex05.service.impl.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookServiceTest {
    @Test
    public void bookService(){
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("config/beans.xml");
        BookService bookService = applicationContext.getBean(BookServiceImpl.class);
        bookService.subscribe();
        System.out.println("--------------------------------");
        bookService.discount();
    }
}

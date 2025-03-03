package com.javaee.ex05;

import com.javaee.ex05.proxy.CglibProxy;
import com.javaee.ex05.service.BookService;
import org.junit.Test;

public class CglibProxyTest {
    @Test
    public void bookService (){
        CglibProxy cglibProxy = new CglibProxy();
        BookService bookService
                = (BookService)cglibProxy.createCglibPorxy(new BookService());
        bookService.subscribe();
        bookService.discount();
    }
}

package com.javaee.ex05;

import com.javaee.ex05.proxy.BookProxy;
import com.javaee.ex05.service.BookService;
import com.javaee.ex05.service.impl.BookServiceImpl;
import org.junit.Test;

public class BookProxyTest {
    @Test
    public void bookService(){
        BookProxy bookProxy = new BookProxy();
        BookService bookService
                = (BookService)bookProxy.createDynamicProxy(new BookServiceImpl());
        bookService.subscribe();
        bookService.discount();
    }
}

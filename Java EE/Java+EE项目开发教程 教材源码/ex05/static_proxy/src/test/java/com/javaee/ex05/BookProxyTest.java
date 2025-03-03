package com.javaee.ex05;

import com.javaee.ex05.proxy.BookProxy;
import com.javaee.ex05.proxy.Enhance;
import com.javaee.ex05.service.BookService;
import com.javaee.ex05.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

public class BookProxyTest {
    @Test
    public void bookService(){
        BookProxy bookProxy = new BookProxy();
        bookProxy.setBookService(new BookServiceImpl());
        bookProxy.setEnchance(new Enhance());
        BookService bookService = bookProxy;
        bookService.subscribe();
    }

}

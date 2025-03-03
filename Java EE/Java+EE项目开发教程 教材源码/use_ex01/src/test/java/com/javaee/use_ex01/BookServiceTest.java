package com.javaee.use_ex01;

import org.junit.Test;

public class BookServiceTest {
    @Test
    public void getNewPriceTest(){
        BookService bookService = new BookService();
        float newPrice = bookService.getNewPrice(125.8f, 0.8f);
        System.out.println("newPrice=" + newPrice);
    }
}

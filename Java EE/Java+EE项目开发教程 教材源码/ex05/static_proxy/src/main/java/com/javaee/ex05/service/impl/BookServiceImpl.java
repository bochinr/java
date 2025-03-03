package com.javaee.ex05.service.impl;

import com.javaee.ex05.service.BookService;

public class BookServiceImpl implements BookService {
    @Override
    public void subscribe() {
        System.out.println("向出版社订阅图书");
    }
}

package com.javaee.ex05.service.impl;

import com.javaee.ex05.service.BookService;

public class BookServiceImpl implements BookService {
    public void subscribe() {
        System.out.println("向出版社订阅图书");
    }
    public void discount() {
        System.out.println("出版社提供了图书的折扣价");
        // int n = 1 / 0;
    }
}

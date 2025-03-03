package com.javaee.ex05.proxy;

import com.javaee.ex05.service.BookService;

public class BookProxy implements BookService {
    private Enhance enhance;
    private BookService bookService;
    public void subscribe() {
        enhance.priviligeCheck();    // 增加权限检查功能
        bookService.subscribe();     // 被增强方法原来的功能
        enhance. logFile();         // 增加日志记录功能
    }

    public Enhance getEnchance() {
        return enhance;
    }

    public void setEnchance(Enhance enhance) {
        this.enhance = enhance;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}

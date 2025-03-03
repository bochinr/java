package com.javaee.ex10_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @GetMapping("/to_book_list")
    public String toBookList(){
        return "book/book_list";
    }
    @GetMapping("/to_book_apply")
    public String toBookApply(){
        return "book/book_apply";
    }
}

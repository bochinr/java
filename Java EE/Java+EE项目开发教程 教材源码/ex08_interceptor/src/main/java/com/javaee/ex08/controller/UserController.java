package com.javaee.ex08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/login")
    @ResponseBody
    public void login(){
        System.out.println("login()处理器被运行");
    }
}

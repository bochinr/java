package com.javaee.ex10_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commons")
public class UserController {
    @GetMapping("/to_login")
    public String toLogin(){
        return "commons/login";
    }
    @GetMapping("/denied_access")
    public String deniedAccess(){
        return "commons/denied_access";
    }
}

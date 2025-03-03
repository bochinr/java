package com.javaee.ex09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/to_login")
    @ResponseBody
    public String toLogin(String loginName){
        return "处理器收到信息：" + loginName;
    }
}

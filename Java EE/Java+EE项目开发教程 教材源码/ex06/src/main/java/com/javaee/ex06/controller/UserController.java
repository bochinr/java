package com.javaee.ex06.controller;

import com.javaee.ex06.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/to_login")
    public String toLogin(){
        return "user/login";
    }
    @RequestMapping("/login")
    public String login(@RequestParam("login_name") String loginName,
                        String password, Model model){
        if (!password.equals("888888")) {
            model.addAttribute("login_error","登录失败，请重试！");
            return "forward:to_login"; // 转发请求（不含公共路径）
            //return "redirect:to_login"; // 重定向请求（不含公共路径）
        }
        model.addAttribute("login_name",loginName);
        model.addAttribute("password",password);
        return "user/main";
    }
    @RequestMapping("/to_index")
    public String toIndex(){
        return "redirect:/index.jsp";
    }
    @GetMapping("/show_users")
    public String showUsers(Model model){
        List<User> userList = new ArrayList<>();
        userList.add(new User("张晓伟",20, "13588886666"));
        userList.add(new User("李枫雅",19, "13647897858"));
        userList.add(new User("宋明宇",21, "13534574596"));
        model.addAttribute("user_list", userList);
        return "user/show_users";
    }
}


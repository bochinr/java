package com.javaee.ex11.controller;

import com.javaee.ex11.po.User;
import com.javaee.ex11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "user/login";
    }

    @RequestMapping("/to_register")
    public String toRegister(){
        return "user/register";
    }

    @RequestMapping("/login")
    public String login(User user, int roleId, HttpSession session, Model model){
        if (!userService.isValidatedUser(user, roleId)){
            model.addAttribute("login_error","登录未成功！");
            return "user/login";
        }
        System.out.println(roleId);
        session.setAttribute("loginName",user.getLoginName());
        session.setAttribute("roleId",roleId);
        int homePage = roleId > 2 ? 8 : roleId;
        return "forward:/to_home_page?page=1&homePage=" + homePage;
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(User user, Model model){
        System.out.println(user);
        boolean res = userService.registerUser(user);
        if (res)
            return "SUCCESS";
        return "FAIL";
    }

    @RequestMapping("/delete_user")
    @ResponseBody
    public String deleteUser(int userId){
        int res = userService.deleteUserByUserId(userId);
        return res > 0 ? "SUCCESS" : "FAIL";
    }

    @RequestMapping("/to_edit_user")
    @ResponseBody
    public User toEditUser(int userId){
        User user = userService.findUserByUserId(userId);
        return user;
    }

    @RequestMapping("/reset_password")
    @ResponseBody
    public String resetPassword(int userId){
        int res = userService.resetPassword(userId);
        return res > 0 ? "SUCCESS" : "FAIL";
    }

    @RequestMapping("/save_user")
    public String saveUser(User user, int[] roleIds){
        if (user.getUserId() > 0){  // 编辑
            userService.updateUser(user, roleIds);
        }
        else{   // 添加
            // 新用户密码固定，角色为教师
            user.setPassword("888888");
            userService.addUser(user);
        }
        return "forward:/to_home_page?page=1&homePage=1";
    }
    @RequestMapping("/modify_pwd")
    @ResponseBody
    public String modifyPwd(String originPwd, String newPwd, String loginName){
        int ret = userService.updatePassword(originPwd, newPwd, loginName);
        if (ret > 0)
            return "SUCCESS";
        return "FAIL";
    }
}
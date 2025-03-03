package com.javaee.ex05;

import com.javaee.ex05.po.User;
import com.javaee.ex05.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    @Test
    public void addUserTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/beans.xml");
        UserService userService = ac.getBean(UserService.class);
        User user = new User();
        user.setLoginName("liang");
        user.setPassword("123456");
        user.setUserName("梁芳");
        user.setMobile("18012547858");
        userService.addUser(user, 1);
    }
}

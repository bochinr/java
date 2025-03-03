package com.javaee.ex11.controller;

import com.javaee.ex11.mapper.DistributeBookMapper;
import com.javaee.ex11.mapper.UserMapper;
import com.javaee.ex11.po.DistributeBook;
import com.javaee.ex11.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
@RequestMapping("/distribute")
public class DistributeBookController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DistributeBookMapper distributeBookMapper;

    @RequestMapping("/distribute_book")
    public String distributeBook(DistributeBook distributeBook, HttpSession session){
        String loginName = (String)session.getAttribute("loginName");
        int userId = userMapper.findUserIdByLoginName(loginName);
        User user = new User();
        user.setUserId(userId);
        distributeBook.setUser(user);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        distributeBook.setDistributeDate(simpleDateFormat.format(Calendar.getInstance().getTime()));

        // 注意，这里未考虑发放后，更新库存，也没有检查库存不足的情况
        // 若考虑库存更新的情况，需要调整数据库，此外，入库数量也要可调（目前是申请多少本，就入库多少本，而且不能提供有效的多次入库累积的功能）
        // 读者可考虑对当前系统，进一步优化，使得需求及实现更加合理
        distributeBookMapper.addDistributeBook(distributeBook);
        return "forward:/to_home_page?page=1&homePage=5";
    }
}

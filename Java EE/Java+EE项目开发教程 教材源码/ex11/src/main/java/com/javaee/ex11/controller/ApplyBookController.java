package com.javaee.ex11.controller;

import com.javaee.ex11.mapper.ApplyBookMapper;
import com.javaee.ex11.mapper.UserMapper;
import com.javaee.ex11.po.ApplyBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
@RequestMapping("/apply")
public class ApplyBookController {
    @Autowired
    private ApplyBookMapper applyBookMapper;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/to_edit_apply_book")
    @ResponseBody
    public int toEditApplyBook(int applyBookId){
        ApplyBook applyBook = applyBookMapper.findApplyBookByApplyBookId(applyBookId);
        return applyBook.getApplyCount();
    }

    @RequestMapping("/edit_apply_book")
    public String editApplyBook(ApplyBook applyBook){
        applyBookMapper.editApplyCount(applyBook);
        return "forward:/to_home_page?page=1&homePage=7";
    }

    @RequestMapping("/approve_apply")
    public String approveApply(ApplyBook applyBook, HttpSession session){
        String loginName = (String)session.getAttribute("loginName");
        int userId = userMapper.findUserIdByLoginName(loginName);
        applyBook.setApprover(userId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        applyBook.setApproveDate(simpleDateFormat.format(Calendar.getInstance().getTime()));
        applyBookMapper.approveApply(applyBook);
        return "forward:/to_home_page?page=1&homePage=3";
    }

    @RequestMapping("/in_storage_book")
    @ResponseBody
    public String inStorageApply(int applyBookId){
        ApplyBook applyBook = new ApplyBook();
        applyBook.setApplyStatus(3);
        applyBook.setApplyBookId(applyBookId);
        int res = applyBookMapper.editApplyBookStatus(applyBook);
        return res > 0 ? "SUCCESS" : "FAIL";
    }
}

package com.javaee.ex11.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaee.ex11.mapper.*;
import com.javaee.ex11.po.*;
import com.javaee.ex11.service.UserService;
import com.javaee.ex11.tools.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private PublisherMapper publisherMapper;
    @Autowired
    private ApplyBookMapper applyBookMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DistributeBookMapper distributeBookMapper;

    private String loginName;

    @RequestMapping("/to_home_page")
    public String toHomePage(int page, int homePage, HttpSession session, Model model){
        session.setAttribute("homePage", homePage);
        loginName = (String)session.getAttribute("loginName");
        getData(page, homePage, model);
        return "home_page";
    }
    @RequestMapping("/to_logout")       // 注销
    public String toLogout(HttpSession session){
        session.removeAttribute("loginName");
        session.removeAttribute("roleId");
        return "user/login";
    }
    private void getData(int page, int homePage, Model model){
        int pageSize = 10;
        PageHelper.startPage(page, pageSize);
        //List<Book> bookList = null;
        //PageInfo<Book> pageInfoBook = null;
        switch (homePage){
            case 1: // 用户数据

                List<User> userList = userService.findUsers();
                PageInfo<User> pageInfo = new PageInfo<>(userList);
                model.addAttribute("pageInfo", pageInfo);
                break;
            case 2: // 课程管理
                List<Course> courseList = courseMapper.findCourses();
                PageInfo<Course> pageInfoCourse = new PageInfo<>(courseList);
                model.addAttribute("pageInfo", pageInfoCourse);
                break;
            case 3: // 审批管理
                //int userId = userMapper.findUserIdByLoginName(loginName);
                List<ApplyBook> applyBookList1 = applyBookMapper.findNoApprovedApplyBooks();
                for (int i = 0; i < applyBookList1.size(); i ++){
                    applyBookList1.get(i).setApplyStatusText(SysConstant.APPLY_STATUS[applyBookList1.get(i).getApplyStatus()]);
                }
                PageInfo<ApplyBook> pageInfoApplyBook1 = new PageInfo<>(applyBookList1);
                model.addAttribute("pageInfo", pageInfoApplyBook1);
                break;
            case 4: // 入库管理
                List<ApplyBook> applyBookList2 = applyBookMapper.findApprovedApplyBooks();
                for (int i = 0; i < applyBookList2.size(); i ++){
                    applyBookList2.get(i).setApplyStatusText(SysConstant.APPLY_STATUS[applyBookList2.get(i).getApplyStatus()]);
                }
                PageInfo<ApplyBook> pageInfoApplyBook2 = new PageInfo<>(applyBookList2);
                model.addAttribute("pageInfo", pageInfoApplyBook2);
                break;
            case 5: // 教材发放
                List<ApplyBook> applyBookList3 = applyBookMapper.findApplyBooksInStorage();
                for (int i = 0; i < applyBookList3.size(); i ++){
                    applyBookList3.get(i).setApplyStatusText(SysConstant.APPLY_STATUS[applyBookList3.get(i).getApplyStatus()]);
                }
                PageInfo<ApplyBook> pageInfoApplyBook3 = new PageInfo<>(applyBookList3);
                model.addAttribute("pageInfo", pageInfoApplyBook3);
                break;
            case 6: // 教材申请
                List<Book> bookList = bookMapper.findBooks();
                //System.out.println(bookList);
                PageInfo<Book> pageInfoBook = new PageInfo<>(bookList);
                model.addAttribute("pageInfo", pageInfoBook);
                List<Publisher> publisherList1 = publisherMapper.findPublishers();
                model.addAttribute("publishers", publisherList1);
                List<Course> courseList1 = courseMapper.findCourses();
                model.addAttribute("courses", courseList1);
                break;
            case 7: // 查看申请
                int userId = userMapper.findUserIdByLoginName(loginName);
                List<ApplyBook> applyBookList = applyBookMapper.findApplyBooksByUserId(userId);
                for (int i = 0; i < applyBookList.size(); i ++){
                    applyBookList.get(i).setApplyStatusText(SysConstant.APPLY_STATUS[applyBookList.get(i).getApplyStatus()]);
                }
                PageInfo<ApplyBook> pageInfoApplyBook = new PageInfo<>(applyBookList);
                model.addAttribute("pageInfo", pageInfoApplyBook);
                break;
            case 8: // 出版社管理
                List<Publisher> publisherList = publisherMapper.findPublishers();
                PageInfo<Publisher> pageInfoPublisher = new PageInfo<>(publisherList);
                model.addAttribute("pageInfo", pageInfoPublisher);
                break;
            case 9: // 修改密码
                break;
            case 10: // 发放历史查询
                List<DistributeBook> distributeBookList = distributeBookMapper.findDistributeBooks();
                PageInfo<DistributeBook> pageInfoDistributeBook = new PageInfo<>(distributeBookList);
                model.addAttribute("pageInfo", pageInfoDistributeBook);
        }
    }
}

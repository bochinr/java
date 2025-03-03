package com.javaee.ex11.controller;

import com.javaee.ex11.mapper.ApplyBookMapper;
import com.javaee.ex11.mapper.BookMapper;
import com.javaee.ex11.mapper.UserMapper;
import com.javaee.ex11.po.ApplyBook;
import com.javaee.ex11.po.Book;
import com.javaee.ex11.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private ApplyBookMapper applyBookMapper;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/save_book")
    public String saveBook(Book book){
        System.out.println(book);
        if (book.getBookId() > 0)
            bookMapper.editBook(book);
        else
            bookMapper.addBook(book);
        return "forward:/to_home_page?page=1&homePage=6";
    }

    @RequestMapping("/to_edit_book")
    @ResponseBody
    public Book toEditBook(int bookId){
        return bookMapper.findBookByBookId(bookId);
    }

    @RequestMapping("/delete_book")
    @ResponseBody
    public String deleteBook(int bookId){
        int count = applyBookMapper.findApplyCountByBookId(bookId);
        if (count > 0)  // 如果课程信息与其他信息存在外键约束，不能删除
            return "FAIL";
        int res = bookMapper.deleteBook(bookId);
        return res > 0 ? "SUCCESS" : "FAIL";
    }
    @RequestMapping("/add_apply")
    public String applyBook(ApplyBook applyBook, HttpSession session, Model model){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        applyBook.setApplyDate(simpleDateFormat.format(Calendar.getInstance().getTime()));

        applyBook.setUser(new User());
        String loginName = (String)session.getAttribute("loginName");
        int userId = userMapper.findUserIdByLoginName(loginName);
        applyBook.getUser().setUserId(userId);
        System.out.println(applyBook);

        int res = applyBookMapper.addApplyBook(applyBook);
        model.addAttribute("operStatus",res > 0 ? "SUCCESS" : "FAIL");
        return "forward:/to_home_page?page=1&homePage=6";
    }
/*    @Autowired
    private BookService bookService;
    @RequestMapping("/add_apply")
    public String addApply(Book book){
        bookService.addApply(book);
        return "forward:/to_home_page?page=1&homePage=7";
    }
    @RequestMapping("/distribute_book")
    public String distributeBook(int bookId){
        return "SUCCESS";
    }*/
}

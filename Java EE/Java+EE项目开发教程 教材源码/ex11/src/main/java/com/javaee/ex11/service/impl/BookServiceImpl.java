package com.javaee.ex11.service.impl;

import com.javaee.ex11.mapper.BookMapper;
import com.javaee.ex11.mapper.UserMapper;
import com.javaee.ex11.po.Book;
import com.javaee.ex11.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BookServiceImpl implements BookService {
/*    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Book> findApplysByLoginName(String loginName) {
        int userId = userMapper.findUserIdByLoginName(loginName);
        return null;//bookMapper.findApplysByUserId(userId);
    }

    @Override
    public List<Book> findApplys() {
        return null;//bookMapper.findApplys();
    }

    @Override
    public int addApply(Book book) {
        return 0;
    }*/
}

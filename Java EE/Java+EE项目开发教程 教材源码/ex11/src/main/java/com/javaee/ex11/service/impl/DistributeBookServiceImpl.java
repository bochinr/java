package com.javaee.ex11.service.impl;

import com.javaee.ex11.mapper.DistributeBookMapper;
import com.javaee.ex11.mapper.UserMapper;
import com.javaee.ex11.service.DistributeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistributeBookServiceImpl implements DistributeBookService {
    @Autowired
    private DistributeBookMapper distributeBookMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean DistributeBook() {
        return false;
    }
}

package com.javaee.ex09.service.impl;

import com.javaee.ex09.po.Publisher;
import com.javaee.ex09.service.PublisherService;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Override
    public Publisher getPublisherByPubId(int pubId) {
        System.out.println("查询pub_id为" + pubId + "的Publisher信息");
        return null;
    }
}

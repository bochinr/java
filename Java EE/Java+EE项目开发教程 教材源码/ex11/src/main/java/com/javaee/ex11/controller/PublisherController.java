package com.javaee.ex11.controller;

import com.javaee.ex11.mapper.BookMapper;
import com.javaee.ex11.mapper.PublisherMapper;
import com.javaee.ex11.po.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherMapper publisherMapper;
    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/save_publisher")
    public String savePublisher(Publisher publisher){
        System.out.println(publisher);
        if (publisher.getPubId() > 0)
            publisherMapper.editPublisher(publisher);
        else
            publisherMapper.addPublisher(publisher);
        return "forward:/to_home_page?page=1&homePage=8";
    }

    @RequestMapping("/to_edit_publisher")
    @ResponseBody
    public Publisher toEditPublisher(int pubId){
        return publisherMapper.findPublisherByPubId(pubId);
    }

    @RequestMapping("/delete_publisher")
    @ResponseBody
    public String deletePublisher(int pubId){
        int count = bookMapper.findBookCountByPubId(pubId);
        if (count > 0)  // 如果课程信息与其他信息存在外键约束，不能删除
            return "FAIL";
        int res = publisherMapper.deletePublisher(pubId);
        return res > 0 ? "SUCCESS" : "FAIL";
    }
}

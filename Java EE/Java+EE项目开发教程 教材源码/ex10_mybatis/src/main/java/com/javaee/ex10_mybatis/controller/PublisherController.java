package com.javaee.ex10_mybatis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaee.ex10_mybatis.mapper.PublisherMapper;
import com.javaee.ex10_mybatis.po.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PublisherController {
    @Autowired
    private PublisherMapper publisherMapper;
    @RequestMapping("/publisher_list")
    public String publisherList(Model model){
        List<Publisher> publisherList = publisherMapper.findPublishers();
        model.addAttribute("publishers", publisherList);
        return "publisher/publisher_list";
    }
    @RequestMapping("publisher_list_page")
    public String publisherListPage(Model model, @RequestParam(defaultValue="1") int pageNum){
        PageHelper.startPage(pageNum, 3);
        List<Publisher> publisherList = publisherMapper.findPublishers();
        PageInfo<Publisher> pageInfo = new PageInfo<>(publisherList);
        model.addAttribute("pageInfo", pageInfo);
        return "publisher/publisher_list_page";
    }

}

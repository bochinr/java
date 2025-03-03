package com.javaee.ex10_th.controller;

import com.javaee.ex10_th.po.Publisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PublisherController {
    @RequestMapping("/publisher_list")
    public String publisherList(Model model){
        List<Publisher> publisherList = new ArrayList<>();
        Publisher publisher = null;
        publisher = new Publisher(1,"清华大学出版社","张大元", "13588754584");
        publisherList.add(publisher);
        publisher = new Publisher(2, "电子工业出版社","宁枫波","13825421156");
        publisherList.add(publisher);
        publisher = new Publisher(3,"人民邮电出版社", "李树松","13545487456");
        publisherList.add(publisher);
        model.addAttribute("publishers", publisherList);
        return "publisher/publisher_list";
    }
}

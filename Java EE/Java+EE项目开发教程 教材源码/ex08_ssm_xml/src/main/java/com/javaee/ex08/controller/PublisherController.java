package com.javaee.ex08.controller;

import com.javaee.ex08.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;
    @RequestMapping("/find_publisher")
    public String findPublisher(Model model){
        model.addAttribute("publishers", publisherService.findPublishers());
        return "publisher/publisher_list";
    }
}

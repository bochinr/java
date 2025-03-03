package com.javaee.ex09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PublisherController {
    @RequestMapping("/add_publisher")
    @ResponseBody
    public String addPublisher(String pubName, String contacter, Model model){
        System.out.println(pubName);
        System.out.println(contacter);
        return "SUCCESS";
    }
}

package com.javaee.ex10_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @GetMapping("/to_publisher_list")
    public String toPublisherList(){
        return "publisher/publisher_list";
    }
}

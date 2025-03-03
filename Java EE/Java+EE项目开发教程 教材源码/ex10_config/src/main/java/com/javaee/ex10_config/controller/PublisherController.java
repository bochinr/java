package com.javaee.ex10_config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class PublisherController {
    @RequestMapping("/to_publisher_list")
    public String toPublisherList(){
        return "publisher_list";
    }
    @RequestMapping("/date_converter")
    @ResponseBody
    public String testDateConverter(Date pubDate){
        return pubDate.toString();
    }

}

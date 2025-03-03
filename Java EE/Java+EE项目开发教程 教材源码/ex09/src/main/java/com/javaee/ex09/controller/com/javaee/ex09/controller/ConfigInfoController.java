package com.javaee.ex09.controller.com.javaee.ex09.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import com.javaee.ex09.po.Book;
import com.javaee.ex09.po.BookEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigInfoController {
    @Autowired
    private Environment environment;
    @RequestMapping(value="/envi_method")
    @ResponseBody
    public String enviMothed() {
        String str = environment.getProperty("server.port");
        str += "<br/>" + environment.getProperty("spring.session.timeout");
        str += "<br/>" + environment.getProperty("book.author");
        System.out.println("中国");
        System.out.println(str);
        return str;
    }
    @Autowired
    private Book book;
    @RequestMapping("/value_annotation")
    @ResponseBody
    public String valueAnnotation(){
        return book.toString();
    }
    @Autowired
    private BookEx bookEx;
    @RequestMapping("/config_annotation")
    @ResponseBody
    public String configAnnotation(){
        return bookEx.toString();
    }
    private Log log = LogFactory.getLog(ConfigInfoController.class);
    @RequestMapping("/test_log")
    @ResponseBody
    public String testLog(){
        log.trace("日志输出 trace");
        log.debug("日志输出 debug");
        log.info("日志输出 info");
        log.warn("日志输出 warn");
        log.error("日志输出 error");
        log.fatal("日志输出 fatal");
        return "测试日志配置";
    }

}

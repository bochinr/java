package com.javaee.ex07_json.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaee.ex07_json.po.Publisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @GetMapping("/to_publisher_list")
    public String toPublisherList(){
        return "publisher/publisher_list";
    }
    @PostMapping("/publisher_list_return_object")
    @ResponseBody
    public Publisher addPublisherReturnObject(Publisher publisher){
        System.out.println(publisher);
        // 在数据库中添加出版社信息
        return publisher;
    }
    @PostMapping("/publisher_list_return_response")
    public void addPublisherReturnResponse(@RequestBody Publisher publisher,
                                           HttpServletResponse response) throws IOException {
        System.out.println(publisher);
        // 在数据库中添加出版社信息
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(mapper.writeValueAsString(publisher));
    }
    @PostMapping("/publisher_list_return_status")
    @ResponseBody
    public String addPublisherReturnStatus(Publisher publisher){
        System.out.println(publisher);
        // 在数据库中添加出版社信息
        return "OK";
    }
    @PostMapping("/delete_publisher")
    @ResponseBody
    public String deletePublisher(String pubIds){
        System.out.println(pubIds);
        // 在数据库中根据pubIds删除出版社信息
        return "OK";
    }
}

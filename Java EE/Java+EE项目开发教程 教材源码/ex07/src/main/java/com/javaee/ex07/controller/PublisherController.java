package com.javaee.ex07.controller;

import com.javaee.ex07.po.Publisher;
import com.javaee.ex07.po.Publishers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @GetMapping("/to_add_publishers")
    public String toAddPublishers(){
        return "/publisher/add_publishers";
    }
    @PostMapping("/add_publishers")
    public String addPublishers(Publishers publishers, HttpSession session){
        session.setAttribute("publishers", publishers);
        return "publisher/publisher_list";
    }
    @PostMapping("/delete_publishers")
    public String deletePublishers(Integer[] pubIds, HttpSession session){
        Publishers publishers = (Publishers)session.getAttribute("publishers");
        List<Publisher> publisherList = publishers.getPublisherList();
        for (int i = 0; i < pubIds.length; i++) {
            for (int j = publisherList.size() - 1; j >= 0 ; j --)
                if (pubIds[i] == publisherList.get(j).getPubId())
                    publisherList.remove(j);
        }
        publishers.setPublisherList(publisherList);
        session.setAttribute("publishers", publishers);
        return "publisher/publisher_list";
    }
}

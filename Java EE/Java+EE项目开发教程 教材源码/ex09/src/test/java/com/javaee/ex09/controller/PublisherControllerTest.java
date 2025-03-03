package com.javaee.ex09.controller;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Before
    public void ready(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        //mockMvc = MockMvcBuilders.standaloneSetup(new PublisherController()).build();
    }
    @Test
    public void addPublisherTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/add_publisher")
                .param("pubName","电子工业出版社")
                .param("contacter", "张是非")).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}

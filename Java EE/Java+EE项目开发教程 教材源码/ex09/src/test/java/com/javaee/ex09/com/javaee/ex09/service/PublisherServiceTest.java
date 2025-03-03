package com.javaee.ex09.com.javaee.ex09.service;
import com.javaee.ex09.service.PublisherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherServiceTest {
    @Autowired
    private PublisherService publisherService;
    @Test
    public void publisherServiceTest(){
        publisherService.getPublisherByPubId(1);
    }
}

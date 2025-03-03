package com.javaee.ex05.mapper;
import com.javaee.ex05.po.Publisher;
import java.util.List;

public interface PublisherMapper {
    List<Publisher> findAllPublishers();
}

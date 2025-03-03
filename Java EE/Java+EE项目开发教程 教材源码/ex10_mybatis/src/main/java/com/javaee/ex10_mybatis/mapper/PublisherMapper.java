package com.javaee.ex10_mybatis.mapper;

import com.javaee.ex10_mybatis.po.Publisher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PublisherMapper {
    List<Publisher> findPublishers();
}

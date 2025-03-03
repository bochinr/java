package com.javaee.ex11.mapper;

import com.javaee.ex11.po.DistributeBook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DistributeBookMapper {
    int addDistributeBook(DistributeBook distributeBook);
    List<DistributeBook> findDistributeBooks();
}

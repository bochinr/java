package com.javaee.ex03.mapper;

import com.javaee.ex03.po.Book;

import java.util.List;
import java.util.Map;

public interface BookDynamicMapper {
    List<Book> findBookByBookName(String bookName);
    List<Book> findBookByParams(Book book);
    List<Book> findBookByBookIdArray(Integer[] bookIdArray);
    List<Book> findBookByBookIdList(List<Integer> bookIdList);
    List<Book> findBookByBookIdMap(Map<String, Object> bookIdMap);
    int updateBook(Book book);
}

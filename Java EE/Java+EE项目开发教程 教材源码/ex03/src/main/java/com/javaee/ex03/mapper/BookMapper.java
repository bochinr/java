package com.javaee.ex03.mapper;

import com.javaee.ex03.po.Book;
import java.util.List;

public interface BookMapper {
    Book findBookByBookId(int bookId);
    List<Book> findBookByBookName(String bookName);
    List<Book> findBookByPrice(float price);
    int insertBook(Book book);
    List<Book> findBookByPubId(int pubId);
    List<Book> findBookByUserId(int userId);
}

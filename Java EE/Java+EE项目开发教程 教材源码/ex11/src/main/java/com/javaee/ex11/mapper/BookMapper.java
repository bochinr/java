package com.javaee.ex11.mapper;

import com.javaee.ex11.po.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    Book findBookByBookId(int bookId);
    List<Book> findBooks();
    int editBook(Book book);
    int addBook(Book book);
    int deleteBook(int bookId);
/*    List<Book> findApplysByUserId(int userId);
    List<Book> findApplys();*/
    int findBookCountByCourseId(int courseId);
    int findBookCountByPubId(int pubId);
}

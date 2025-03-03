package com.javaee.ex03_annotation.mapper;

import com.javaee.ex03_annotation.po.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select({"select * ","from book ","where book_id=#{value};"})
    Book findBookByBookId(int bookId);
    @Options(useGeneratedKeys=true,keyProperty="bookId",keyColumn="book_id")
    @Insert("insert into book(book_name,isbn,price,pub_date,warehousing_date,author,pub_id,inventory) " +
            "values(#{bookName},#{isbn},#{price},#{pubDate},#{warehousingDate},#{author},#{pubId},#{inventory});")
    int insertBook(Book book);
    @Update("update book set book_name=#{bookName},price=#{price} where book_id=#{bookId};")
    int updateBook(Book book);
    @Delete("delete from book where book_id=#{value};")
    int deleteBook(int bookId);
    @Select({"select * from book ","where pub_id=#{id} or price>#{price};"})
    List<Book> findBookByPubIdAndPrice(@Param("id") int pubId, @Param("price") float price);
    @Select("select * from book where pub_id=#{value};")
    List<Book> findBookByPubId(int pubId);
    @Select("select * from book where book_id in (select book_id from distribute_book where user_id=#{value});")
    List<Book> findBookByUserId(int userId);
}

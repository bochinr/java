package com.javaee.ex03_annotation;

import com.javaee.ex03_annotation.mapper.BookMapper;
import com.javaee.ex03_annotation.po.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class BookMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void createSqlSessionFactory(){
        try {
            Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findBookByBookIdTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.findBookByBookId(1);
        System.out.println(book);
        sqlSession.close();
    }
    @Test
    public void insertBookTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = new Book();
        book.setBookName("计算机网络");
        book.setIsbn("978-7-145-76889-1");
        book.setPrice(45.5f);
        book.setPubDate("2020-03-19");
        book.setWarehousingDate("2022-09-06");
        book.setAuthor("罗时枫");
        book.setPubId(2);
        book.setInventory(100);
        int result = bookMapper.insertBook(book);
        System.out.println("插入了" + result + "条记录\t新记录的book_id字段值为：" + book.getBookId());
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateBookTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = new Book();
        book.setBookId(5);
        book.setBookName("通信原理");
        book.setPrice(58.5f);
        int result = bookMapper.updateBook(book);
        System.out.println("更新了" + result + "条记录");
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteBookTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        int result = bookMapper.deleteBook(5);
        System.out.println("删除了" + result + "条记录");
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findBookByBookNameAndPriceTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        List<Book> bookList = bookMapper.findBookByPubIdAndPrice(2, 66.f);
        System.out.println(bookList);
        sqlSession.close();
    }
}

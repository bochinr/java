package com.javaee.ex03;

import com.javaee.ex03.mapper.BookMapper;
import com.javaee.ex03.po.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.Reader;
import java.util.List;

@FixMethodOrder(MethodSorters.JVM)
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
    public void findBookByBookIdTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.findBookByBookId(1);
        System.out.println(book);
        sqlSession.close();
    }
    @Test
    public void findBookByBookNameTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        List<Book> bookList = bookMapper.findBookByBookName("数据");
        System.out.println(bookList);
        sqlSession.close();
    }
    @Test
    public void findBookByBookPriceTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        List<Book> bookList = bookMapper.findBookByPrice(50.0f);
        System.out.println(bookList);
        sqlSession.close();
    }
    @Test
    public void insertBookTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = new Book();
        book.setBookName("高等数学");
        book.setIsbn("978-7-115-45765-8");
        book.setPrice(45.5f);
        book.setPubDate("2019-08-15");
        book.setWarehousingDate("2022-09-25");
        book.setAuthor("颜正伟");
        book.setPubId(1);
        book.setInventory(10);
        int result = bookMapper.insertBook(book);
        System.out.println("插入了" + result + "条记录\t新记录的book_id字段值为：" + book.getBookId());
        sqlSession.commit();
        sqlSession.close();
    }
}

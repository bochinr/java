package com.javaee.ex03;

import com.javaee.ex03.mapper.BookDynamicMapper;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FixMethodOrder(MethodSorters.JVM)  // 按JVM获得的方法顺序执行测试方法
public class BookDynamicMapperTest {
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
    public void findBookByBookNameTest() {
        System.out.println("findBookByBookNameTest:");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookDynamicMapper bookMapper = sqlSession.getMapper(BookDynamicMapper.class);
        List<Book> bookList = bookMapper.findBookByBookName("语言");
        System.out.println(bookList);
        sqlSession.close();
    }
    @Test
    public void findBookByParamsTest() {
        System.out.println("findBookByParamsTest:");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookDynamicMapper bookMapper = sqlSession.getMapper(BookDynamicMapper.class);
        Book book = new Book();
        book.setPrice(50.f);
        List<Book> bookList = bookMapper.findBookByParams(book);
        System.out.println(bookList);
        sqlSession.close();
    }
    @Test
    public void findBookByBookIdsTest() {
        System.out.println("findBookByBookIdsTest:");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookDynamicMapper bookMapper = sqlSession.getMapper(BookDynamicMapper.class);
        Integer[] bookIdArray = {1,3};
        List<Book> bookList = bookMapper.findBookByBookIdArray(bookIdArray);
        System.out.println(bookList);
        List<Integer> bookIdList = new ArrayList<Integer>();
        bookIdList.add(1);bookIdList.add(4);
        bookList = bookMapper.findBookByBookIdList(bookIdList);
        System.out.println(bookList);
        Map<String, Object> bookIdMap = new HashMap<String, Object>();
        bookIdMap.put("bookId", bookIdList);
        bookIdMap.put("author", "张晓泉");
        bookList = bookMapper.findBookByBookIdMap(bookIdMap);
        System.out.println(bookList);
        sqlSession.close();
    }
    @Test
    public void updateBookTest(){
        System.out.println("updateBookTest:");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookDynamicMapper bookMapper = sqlSession.getMapper(BookDynamicMapper.class);
        Book book = new Book();
        book.setBookId(4);
        book.setBookName("高等数学");
        int result = bookMapper.updateBook(book);
        System.out.println("更新了" + result + "条记录");
        sqlSession.commit();
        sqlSession.close();
    }
}

package com.javaee.ex03;

import com.javaee.ex03.mapper.CourseMapper;
import com.javaee.ex03.mapper.PublisherMapper;
import com.javaee.ex03.mapper.UserMapper;
import com.javaee.ex03.po.Course;
import com.javaee.ex03.po.Publisher;
import com.javaee.ex03.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;

public class RelationQueryTest {
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
    public void findCourseByCourseIdTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        Course course = courseMapper.findCourseByCourseId(1);
        System.out.println(course);
        sqlSession.close();
    }
    @Test
    public void findCourseByCourseIdExTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        Course course = courseMapper.findCourseByCourseIdEx(1);
        System.out.println(course);
        sqlSession.close();
    }
    @Test
    public void findPublisherByPubIdTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PublisherMapper publisherMapper = sqlSession.getMapper(PublisherMapper.class);
        Publisher publisher = publisherMapper.findPublisherByPubId(1);
        System.out.println(publisher);
        sqlSession.close();
    }
    @Test
    public void findPublisherByPubIdExTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PublisherMapper publisherMapper = sqlSession.getMapper(PublisherMapper.class);
        Publisher publisher = publisherMapper.findPublisherByPubIdEx(1);
        System.out.println(publisher);
        sqlSession.close();
    }
    @Test
    public void findUserByUserIdTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserByUserId(1);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void findUserByUserIdExTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserByUserIdEx(1);
        System.out.println(user);
        sqlSession.close();
    }
}

package com.javaee.ex03_annotation;

import com.javaee.ex03_annotation.mapper.CourseMapper;
import com.javaee.ex03_annotation.mapper.PublisherMapper;
import com.javaee.ex03_annotation.mapper.UserMapper;
import com.javaee.ex03_annotation.po.Course;
import com.javaee.ex03_annotation.po.Publisher;
import com.javaee.ex03_annotation.po.User;
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
    public void findPublisherByPubIdTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PublisherMapper publisherMapper = sqlSession.getMapper(PublisherMapper.class);
        Publisher publisher = publisherMapper.findPublisherByPubId(1);
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
}

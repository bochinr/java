package com.javaee.ex02;

import com.javaee.ex02.po.Publisher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.Reader;
@FixMethodOrder(MethodSorters.JVM)
public class PublisherMapperTest {
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
    public void findPublisherByPubIdTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Publisher publisher = sqlSession.selectOne(
                "com.javaee.ex02.mapper.PublisherMapper.findPublisherByPubId", 1);
        System.out.println(publisher);
        sqlSession.close();
    }
    @Test
    public void insertPublisherTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Publisher publisher = new Publisher();
        publisher.setPubName("电子工业出版社");
        publisher.setContacter("张晓菲");
        publisher.setMobile("13544784579");
        int res = sqlSession.insert(
                "com.javaee.ex02.mapper.PublisherMapper.insertPublisher", publisher);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("插入了" + res + "条记录！");
    }
    @Test
    public void updatePublisherByPubIdTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Publisher publisher = new Publisher();
        publisher.setPubId(1);
        publisher.setPubName("人民邮电出版社");
        publisher.setContacter("章来福");
        publisher.setMobile("13158475864");
        int res = sqlSession.update(
                "com.javaee.ex02.mapper.PublisherMapper.updatePublisherByPubId", publisher);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("更新了" + res + "条记录！");
    }
    @Test
    public void deletePublisherByPubIdTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int res = sqlSession.delete(
                "com.javaee.ex02.mapper.PublisherMapper.deletePublisherByPubId", 5);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("删除了" + res + "条记录！");
    }
}

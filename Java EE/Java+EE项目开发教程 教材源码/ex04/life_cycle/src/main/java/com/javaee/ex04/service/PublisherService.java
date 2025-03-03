package com.javaee.ex04.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class PublisherService implements BeanFactoryAware, DisposableBean, InitializingBean {
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware接口的重写方法被调用");
    }
    public void destroy() throws Exception {
        System.out.println("DisposableBean接口的重写方法被调用");
    }
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean接口的重写方法被调用");
    }
    public void initMethod(){
        System.out.println("initMethod()方法被调用");
    }
    public void destroyMethod(){
        System.out.println("destroyMethod()方法被调用");
    }
}

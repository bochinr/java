package com.javaee.ex05.proxy;

import com.javaee.ex05.service.BookService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookProxy  implements InvocationHandler {
    private BookService bookService;
    public Object createDynamicProxy(BookService bookService){
        this.bookService = bookService;
        ClassLoader classLoader = BookProxy.class.getClassLoader();
        Class[] classes = bookService.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, classes, this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Enhance enhance = new Enhance();
        enhance.priviligeCheck();  // 前置增强
        Object object = method.invoke(bookService, args);  // 调用目标对象方法
        enhance.logFile();        // 后置增强
        return object;
    }
}

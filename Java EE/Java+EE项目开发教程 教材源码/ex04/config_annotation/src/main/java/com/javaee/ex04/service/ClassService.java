package com.javaee.ex04.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClassService {
    @Value("2215711")
    private String classNo;
    @Value("22级软件工程1班")
    private String className;
    @Value("软件工程")
    private String major;
    // 省略了toString方法

    @Override
    public String toString() {
        return "ClassService{" +
                "classNo='" + classNo + '\'' +
                ", className='" + className + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}

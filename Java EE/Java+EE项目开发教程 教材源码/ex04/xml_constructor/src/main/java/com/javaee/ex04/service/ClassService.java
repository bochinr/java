package com.javaee.ex04.service;

public class ClassService {
    private String classNo;
    private String className;
    private String major;
    public ClassService(String classNo, String className, String major) {
        this.classNo = classNo;
        this.className = className;
        this.major = major;
    }

    @Override
    public String toString() {
        return "ClassService{" +
                "classNo='" + classNo + '\'' +
                ", className='" + className + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}

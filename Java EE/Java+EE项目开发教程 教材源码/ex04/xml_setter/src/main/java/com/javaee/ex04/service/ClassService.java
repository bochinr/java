package com.javaee.ex04.service;

public class ClassService {
    private String classNo;
    private String className;
    private String major;

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMajor(String major) {
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

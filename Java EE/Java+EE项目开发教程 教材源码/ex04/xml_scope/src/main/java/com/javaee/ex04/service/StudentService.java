package com.javaee.ex04.service;

public class StudentService {
    private String sno;
    private String sname;
    private ClassService classService;

    public ClassService getClassService() {
        return classService;
    }

    public void setClassService(ClassService classService) {
        this.classService = classService;
    }
}

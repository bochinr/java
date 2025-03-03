package com.javaee.ex04.service;

public class TeacherService {
    private ClassService classService;

    public ClassService getClassService() {
        return classService;
    }

    public void setClassService(ClassService classService) {
        this.classService = classService;
    }
}

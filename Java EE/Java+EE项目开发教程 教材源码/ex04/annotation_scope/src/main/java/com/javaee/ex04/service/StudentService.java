package com.javaee.ex04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class StudentService {
    private String sno;
    private String sname;
    @Autowired
    private ClassService classService;
    public ClassService getClassService() {
        return classService;
    }
}

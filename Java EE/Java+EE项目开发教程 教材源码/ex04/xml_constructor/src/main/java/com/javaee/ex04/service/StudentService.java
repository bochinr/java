package com.javaee.ex04.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentService {
    private String sno;
    private String sname;
    private ClassService classService;
    private List<Float> scoreList;
    private Set<String> interest;
    private Map<String, String> other;
    public StudentService(String sno, String sname, ClassService classService,
                          List<Float> scoreList, Set<String> interest, Map<String, String> other) {
        this.sno = sno;
        this.sname = sname;
        this.classService = classService;
        this.scoreList = scoreList;
        this.interest = interest;
        this.other = other;
    }

    @Override
    public String toString() {
        return "StudentService{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", classService=" + classService +
                ", scoreList=" + scoreList +
                ", interest=" + interest +
                ", other=" + other +
                '}';
    }
}

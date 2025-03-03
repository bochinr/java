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

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

    public void setScoreList(List<Float> scoreList) {
        this.scoreList = scoreList;
    }

    public void setInterest(Set<String> interest) {
        this.interest = interest;
    }

    public void setOther(Map<String, String> other) {
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

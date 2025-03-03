package com.javaee.ex04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@PropertySource(value = "classpath:data.properties",encoding = "utf-8")
public class StudentService {
    @Value("${student.sno}")
    private String sno;
    @Value("${student.sname}")
    private String sname;
    @Autowired
    private ClassService classService;
    @Value("#{'${student.scores}'.split(',')}")
    private List<Float> scoreList;
    @Value("#{'${student.interest}'.split(',')}")
    private Set<String> interest;
    @Value("#{${student.other}}")
    private Map<String, String> other;

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

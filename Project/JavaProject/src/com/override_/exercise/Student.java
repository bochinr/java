package com.override_.exercise;

public class Student extends Person{
    private int id;
    private int score;

    public Student(String name, int age, int id, int score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }
    public String say() {
        return id + score + super.say();
    }
}

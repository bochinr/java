package com.override_.exercise;

public class main {
    public static void main(String[] args) {
        Person person = new Person("xiaoming", 12);
        Student student = new Student("wangli", 13, 1, 122);
        System.out.println(person.say());
        System.out.println(student.say());
    }
}

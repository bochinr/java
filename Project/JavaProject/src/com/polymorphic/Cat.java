package com.polymorphic;

public class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void say() {
        System.out.println("miaomiaomiao");
    }
    public void eat() {
        System.out.println("fish");
    }
}

package com.demo2;

public class Test {

	public static void main(String[] args) {
	Apple apple = new Apple();
	Pear pear = new Pear();
	apple.setName("Æ»¹û");
	pear.setName("Àæ");
	Bady bady = new Bady();
	bady.setName("Tom");
	bady.eating(apple);
	bady.eating(pear);
	}

}

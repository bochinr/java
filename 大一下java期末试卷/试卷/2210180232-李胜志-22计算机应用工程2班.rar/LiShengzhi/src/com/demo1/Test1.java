package com.demo1;

public class Test1 {

	public static void main(String[] args) {
		Person p = new Person();
		p.setName("¿Ó §÷æ");
		p.setAge(19);
		p.show();
		Person p2 = new Person("lishengzhi",19);
		p2.show();
	}

}

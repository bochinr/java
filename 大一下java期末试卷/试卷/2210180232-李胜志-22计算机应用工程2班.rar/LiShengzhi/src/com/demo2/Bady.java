package com.demo2;

public class Bady extends Fruit{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void eating(Fruit fruit) {
		System.out.println(this.name+"ÕıÔÚ³Ô"+fruit);
	}
	
	
}

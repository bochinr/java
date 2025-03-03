package com.extents_.exercise;

public class PC extends Computer{
    private String brand;
    public PC() {}

    public PC(String cup, String memory, int drive, String brand) {
        super(cup, memory, drive);
        this.brand = brand;
    }
    public void printInfo() {
        System.out.println(age);
        System.out.println(getDetail() + brand);
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

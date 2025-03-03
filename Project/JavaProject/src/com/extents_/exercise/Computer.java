package com.extents_.exercise;

public class Computer {
    private String cup;
    private String memory;
    private int drive;
    int age = 18;
    public Computer(String cup, String memory, int drive) {
        this.setCup(cup);
        this.setDrive(drive);
        this.setMemory(memory);
    }
    public Computer(){}

    public String getDetail() {
        return cup + memory + drive;
    }

    public String getCup() {
        return cup;
    }

    public void setCup(String cup) {
        this.cup = cup;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public int getDrive() {
        return drive;
    }

    public void setDrive(int drive) {
        this.drive = drive;
    }
}

package com.extents_.exercise;

public class NotePad extends Computer{
    private String color;
    public NotePad(String cup, String memory, int drive, String color) {
        super(cup, memory, drive);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

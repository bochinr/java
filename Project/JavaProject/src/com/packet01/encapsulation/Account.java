package com.packet01.encapsulation;

public class Account {
    private String name;
    private double balance;
    private String passwd;

    public String getName() {
        return name;
    }
    public Account() { }
//    构造器和set方法结合使用
    public Account(String name, double balance, String passwd) {
        this.name = name;
        this.balance = balance;
        this.passwd = passwd;
    }

    public void setName(String name) {
        if(name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            System.out.println("姓名长度为2-4");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public void info() {
        System.out.println(name + "\t" + balance  + "\t" + passwd);
    }
}

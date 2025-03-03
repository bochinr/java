package com.packet01.encapsulation;

public class AccountTest {
    public static void main(String[] args) {
        Account a1 = new Account();
        a1.setName("xhn");
        a1.setBalance(10);
        a1.setPasswd("24fdsfs");
        System.out.println(a1.getName() + a1.getBalance() + a1.getPasswd());
        Account account = new Account("nih" , 343, "nishf");
        account.info();
    }
}

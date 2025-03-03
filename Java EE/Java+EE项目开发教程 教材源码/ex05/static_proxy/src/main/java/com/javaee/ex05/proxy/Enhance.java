package com.javaee.ex05.proxy;

public class Enhance {
    public void priviligeCheck(){
        System.out.println("经过严格的安全检查");
    }
    public void logFile(){
        System.out.println("写日志文件，记录图书订阅过程");
    }
}

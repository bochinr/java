package com.javaee.ex08.exception;

public class MyException extends Exception{
    private String msg;
    public MyException(String msg){
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

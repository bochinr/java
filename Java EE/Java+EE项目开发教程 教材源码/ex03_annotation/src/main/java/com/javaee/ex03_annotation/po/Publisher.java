package com.javaee.ex03_annotation.po;

import java.util.List;

public class Publisher {
    private int pubId;
    private String pubName;
    private String contacter;
    private String mobile;
    private List<Book> bookList;

    public int getPubId() {
        return pubId;
    }

    public void setPubId(int pubId) {
        this.pubId = pubId;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "pubId=" + pubId +
                ", pubName='" + pubName + '\'' +
                ", contacter='" + contacter + '\'' +
                ", mobile='" + mobile + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}

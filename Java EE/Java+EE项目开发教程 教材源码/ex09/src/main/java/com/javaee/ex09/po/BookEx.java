package com.javaee.ex09.po;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

@Repository
@ConfigurationProperties(prefix = "book")
public class BookEx {
    private int bookId;
    private String bookName;
    private float price;
    private String author;
    @Autowired
    private PublisherEx01 publisher;

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(PublisherEx01 publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "BookEx{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}

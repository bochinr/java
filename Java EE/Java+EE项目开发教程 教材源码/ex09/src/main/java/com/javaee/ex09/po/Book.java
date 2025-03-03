package com.javaee.ex09.po;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class Book {
    @Value("${book.bookId}")
    private int bookId;
    @Value("${book.bookName}")
    private String bookName;
    @Value("${book.price}")
    private float price;
    @Value("${book.author}")
    private String author;
    @Autowired
    private PublisherEx publisherEx;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", publisherEx=" + publisherEx +
                '}';
    }
}

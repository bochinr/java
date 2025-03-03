package com.javaee.ex09.po;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class PublisherEx{
    @Value("${book.publisher.pubId}")
    private int pubId;
    @Value("${book.publisher.pubName}")
    private String pubName;
    @Value("${book.publisher.contacter}")
    private String contacter;

    @Override
    public String toString() {
        return "PublisherEx{" +
                "pubId=" + pubId +
                ", pubName='" + pubName + '\'' +
                ", contacter='" + contacter + '\'' +
                '}';
    }
}

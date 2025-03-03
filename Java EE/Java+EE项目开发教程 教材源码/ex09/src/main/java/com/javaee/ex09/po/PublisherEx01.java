package com.javaee.ex09.po;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

@Repository
@ConfigurationProperties(prefix = "book.publisher")
public class PublisherEx01 {
    private int pubId;
    private String pubName;
    private String contacter;

    public void setPubId(int pubId) {
        this.pubId = pubId;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter;
    }

    @Override
    public String toString() {
        return "PublisherEx01{" +
                "pubId=" + pubId +
                ", pubName='" + pubName + '\'' +
                ", contacter='" + contacter + '\'' +
                '}';
    }
}

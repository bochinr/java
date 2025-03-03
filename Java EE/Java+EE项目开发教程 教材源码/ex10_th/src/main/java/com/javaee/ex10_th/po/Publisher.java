package com.javaee.ex10_th.po;

public class Publisher {
    private int pubId;
    private String pubName;
    private String contacter;
    private String mobile;
    public Publisher(int pubId, String pubName, String contacter, String mobile) {
        this.pubId = pubId;
        this.pubName = pubName;
        this.contacter = contacter;
        this.mobile = mobile;
    }

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
}


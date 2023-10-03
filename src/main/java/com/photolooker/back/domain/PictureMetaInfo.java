package com.photolooker.back.domain;

public class PictureMetaInfo {
    String pictureId;
    String userId;
    String url;
    int rate;

    public PictureMetaInfo(String pictureId, String userId, String url, int rate) {
        this.pictureId = pictureId;
        this.userId = userId;
        this.url = url;
        this.rate = rate;
    }

    public static PictureMetaInfo create(String userId, String url) {
        String pictureId = java.util.UUID.randomUUID().toString().toUpperCase().substring(0, 8);
        return new PictureMetaInfo(pictureId,userId,url, 0);
    }


    public String getPictureId() {
        return pictureId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUrl() {
        return url;
    }

    public int getRate() {
        return rate;
    }
}
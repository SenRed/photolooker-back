package com.photolooker.back.infrastructure.secondary.database;


import com.photolooker.back.domain.PictureMetaInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("PictureMetaInfoEntity")
public class PictureMetaInfoEntity implements Serializable {
    @Id
    String id;
    String userId;
    String url;
    int rate;

    public PictureMetaInfoEntity(String id, String userId, String url, int rate) {
        this.id = id;
        this.userId = userId;
        this.url = url;
        this.rate = rate;
    }

    public static PictureMetaInfoEntity create(PictureMetaInfo pictureMetaInfo) {
        return new PictureMetaInfoEntity(
                pictureMetaInfo.getPictureId(),
                pictureMetaInfo.getUserId(),
                pictureMetaInfo.getUrl(),
                pictureMetaInfo.getRate());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
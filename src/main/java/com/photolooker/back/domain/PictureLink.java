package com.photolooker.back.domain;

import java.util.UUID;

public class PictureLink {

    String path;

    public PictureLink( String userId, String path) {
        this.path = "/%s/%s/%s".formatted(userId, UUID.randomUUID().toString().toUpperCase().substring(0, 8),path);
    }

    public static PictureLink create( String userId, String path) {
        return new PictureLink(userId, path);
    }

    public String getPath() {
        return path;
    }
}
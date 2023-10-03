package com.photolooker.back.domain;

import java.util.List;

public interface PictureMetaInfoRepository {

    List<PictureMetaInfo> getImagesByUserID(String userID);
    void save(PictureMetaInfo pictureMetaInfo);
    void delete(String imageId);
}
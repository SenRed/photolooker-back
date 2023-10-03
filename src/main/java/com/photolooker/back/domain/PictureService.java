package com.photolooker.back.domain;

import java.io.IOException;

public abstract class PictureService {

    private final BlobRepository blobRepository;
    private final PictureMetaInfoRepository pictureMetaInfoRepository;

    public PictureService(BlobRepository blobRepository, PictureMetaInfoRepository pictureMetaInfoRepository) {
        this.blobRepository = blobRepository;
        this.pictureMetaInfoRepository = pictureMetaInfoRepository;
    }

    public String save(String userId, String name, byte[] fileContent) throws IOException {
        // Save the picture in blob repository
        String pictureURL = blobRepository.savePicture(userId, name, fileContent);
        // Save the meta of the picture in permanent database
        pictureMetaInfoRepository.save(PictureMetaInfo.create(userId, pictureURL));

        return pictureURL;
    }

}
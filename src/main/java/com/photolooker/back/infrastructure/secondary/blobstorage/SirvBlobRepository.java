package com.photolooker.back.infrastructure.secondary.blobstorage;

import com.photolooker.back.domain.BlobRepository;
import com.photolooker.back.domain.PictureLink;
import org.springframework.stereotype.Repository;


@Repository
public class SirvBlobRepository implements BlobRepository {


    private final SirvClient client;

    public SirvBlobRepository(SirvClient client) {
        this.client = client;
    }


    @Override
    public String savePicture(String userId, String fileName, byte[] fileContent) {
        final PictureLink pictureLink = PictureLink.create(userId, fileName);
        this.uploadFile(pictureLink.getPath(), fileContent);
        return SirvClient.READ_SIRV_URL+pictureLink.getPath();
    }

    public void uploadFile(String remoteFilePath, byte[] fileContent) {
        client.uploadFile(remoteFilePath, fileContent);
    }

}
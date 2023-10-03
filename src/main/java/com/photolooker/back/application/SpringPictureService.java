package com.photolooker.back.application;

import com.photolooker.back.domain.BlobRepository;
import com.photolooker.back.domain.PictureMetaInfoRepository;
import com.photolooker.back.domain.PictureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class SpringPictureService extends PictureService {

    public SpringPictureService(BlobRepository blobRepository, PictureMetaInfoRepository pictureMetaInfoRepository) {
        super(blobRepository, pictureMetaInfoRepository);
    }

    @Transactional
    public String save(String userId, String filename, byte[] fileContent) throws IOException {
        return super.save(userId,filename, fileContent);
    }
}
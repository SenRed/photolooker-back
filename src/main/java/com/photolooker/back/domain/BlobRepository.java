package com.photolooker.back.domain;

import java.io.IOException;

public interface BlobRepository {

    String savePicture(String userId, String name, byte[] fileContent) throws IOException;

}
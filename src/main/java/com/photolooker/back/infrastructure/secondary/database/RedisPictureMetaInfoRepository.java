package com.photolooker.back.infrastructure.secondary.database;

import com.photolooker.back.domain.PictureMetaInfo;
import com.photolooker.back.domain.PictureMetaInfoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedisPictureMetaInfoRepository implements PictureMetaInfoRepository {

    private final RedisEntityRepository redisEntityRepository;

    public RedisPictureMetaInfoRepository(RedisEntityRepository redisEntityRepository) {
        this.redisEntityRepository = redisEntityRepository;
    }

    @Override
    public List<PictureMetaInfo> getImagesByUserID(String userID) {
        return null;
    }

    @Override
    public void save(PictureMetaInfo pictureMetaInfo) {
        this.redisEntityRepository.save(PictureMetaInfoEntity.create(pictureMetaInfo));
    }

    @Override
    public void delete(String imageId) {
        // TODO: implement me !
        throw new RuntimeException("Implement me!");
    }
}
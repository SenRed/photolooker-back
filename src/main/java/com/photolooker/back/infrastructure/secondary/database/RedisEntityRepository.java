package com.photolooker.back.infrastructure.secondary.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisEntityRepository extends CrudRepository<PictureMetaInfoEntity, String> {
}
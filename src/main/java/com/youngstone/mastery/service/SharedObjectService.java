package com.youngstone.mastery.service;

import org.springframework.stereotype.Service;

import com.youngstone.mastery.entity.SharedObjectEntity;
import com.youngstone.mastery.model.SharedObjectResponseV1;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SharedObjectService {

    private final SharedObjectDataFetcher sharedObjectDataFetcher;

    public SharedObjectResponseV1 getSharedObject(int id) {

        SharedObjectEntity sharedObjectEntity = sharedObjectDataFetcher.getSharedObjectData(id);
        SharedObjectResponseV1 sharedObjectResponseV1 = SharedObjectResponseV1
                .builder()
                .id(id)
                .count(sharedObjectEntity.count())
                .build();
        return sharedObjectResponseV1;
    }

}

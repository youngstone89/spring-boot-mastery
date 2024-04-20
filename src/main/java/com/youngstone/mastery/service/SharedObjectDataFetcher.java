package com.youngstone.mastery.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.youngstone.mastery.entity.SharedObjectEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SharedObjectDataFetcher {

    public SharedObjectEntity getSharedObjectData(int id) {
        SharedObjectEntity sharedObjectEntity = new SharedObjectEntity();
        int SIZE = 10_000;
        CompletableFuture<Integer>[] futures = new CompletableFuture[SIZE];
        for (int i = 0; i < futures.length; i++) {
            final int val = i;
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                log.info("[id=" + id + "]future[" + val + "]" + Thread.currentThread().getName() + "\t put val:" + val);
                return Integer.valueOf(val);
            });
            futures[i] = future;
        }
        CompletableFuture<Void> all = CompletableFuture.allOf(futures);
        all.thenAccept(Void -> {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int i = 0; i < futures.length; i++) {
                futures[i].join();
                Integer val = futures[i].join();
                temp.put(val, val);
            }
            sharedObjectEntity.putAll(temp);
        });
        all.join();
        return sharedObjectEntity;
    }

}

package com.youngstone.mastery.cache;

import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class CaffeineCache {
    private final Cache<String, DataObject> cache;

    public CaffeineCache() {
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(100)
                .build();
    }

    public void Invalidate(final String key) {
        cache.invalidate(key);
    }

    public DataObject GetIfPresent(final String key) {
        return cache.getIfPresent(key);
    }

    public DataObject Get(final String key) {
        return cache.get(key, k -> DataObject.get("fallback"));
    }

    public void Put(final String key, final DataObject v) {
        cache.put(key, v);
    }

}

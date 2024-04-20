package com.youngstone.mastery.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class CaffeineCacheTest {

    @Test
    void testInvalidate() {
        CaffeineCache cacheClient = new CaffeineCache();
        cacheClient.Put("A", DataObject.get("new"));
        cacheClient.Invalidate("A");
        DataObject dataObj = cacheClient.GetIfPresent("A");
        assertNull(dataObj);

    }

    @Test
    void testGetFallBack() {
        CaffeineCache cacheClient = new CaffeineCache();
        DataObject dataObj = cacheClient.Get("A");
        assertNotNull(dataObj);
        assertEquals("fallback", dataObj.getData());
    }

    @Test
    void testGetIfPresent() {
        CaffeineCache cacheClient = new CaffeineCache();
        DataObject dataObj = cacheClient.GetIfPresent("A");
        assertNull(dataObj);
    }

    @Test
    void testGetIfPresentAfterPut() {
        CaffeineCache cacheClient = new CaffeineCache();
        cacheClient.Put("A", DataObject.get("new data"));
        DataObject dataObj = cacheClient.GetIfPresent("A");
        assertNotNull(dataObj);
    }

}

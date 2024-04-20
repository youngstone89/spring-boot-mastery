package com.youngstone.mastery.entity;

import java.util.HashMap;
import java.util.Map;

public class SharedObjectEntity {

    private Map<Integer, Integer> sharedMap = new HashMap();

    public void putAll(Map<Integer, Integer> map) {
        sharedMap.putAll(map);
    }

    public int count() {
        return sharedMap.size();
    }

}

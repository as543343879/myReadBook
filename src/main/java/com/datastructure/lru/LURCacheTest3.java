package com.datastructure.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LURCacheTest3 class
 *
 * @author 格林
 * @date 2021-06-20
 */
public class LURCacheTest3<K,V>  extends LinkedHashMap<K,V> {
    private int cacheSize;

    public LURCacheTest3(int cacheSize) {
        super(16,0.75f,true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> entry) {
        return size() > cacheSize;
    }
}

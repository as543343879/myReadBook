package com.datastructure.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRUCacheTow class
 *
 * @author 格林
 * @date 2021-06-19
 */
public class LRUCacheTow<K,V> extends LinkedHashMap<K,V> {
    private int cacheSize;
    public LRUCacheTow(int cacheSize) {
        super(16,0.75f,true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
    public static void main(String[] args) {
        LRUCacheTow<Integer,Integer> map = new LRUCacheTow<>(3);
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        System.out.println(map);
    }
}

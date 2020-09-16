package com.datastructure.sort;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    
  private int cacheSize;
  
  public LRUCache(int cacheSize) {
      super(16,0.75f,true);
      this.cacheSize = cacheSize;
  }

  /**
   * 判断元素个数是否超过缓存容量
   */
  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
      return size() > cacheSize;
  }
}


package com.datastructure.lru;

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

  public static void main(String[] args) {
          LRUCache<String,String> cache = new LRUCache<>(2);
          cache.put("1","1");
        cache.put("2","2");
      cache.get("1");
      cache.put("3","3");

        System.out.println(cache);
//      Iterator<Map.Entry<String, String>> iterator = cache.entrySet().iterator();
//      while (iterator.hasNext()) {
//          Map.Entry<String, String> next = iterator.next();
//          System.out.println(next.getKey()  + " " + next.getValue());
//      }
  }
}


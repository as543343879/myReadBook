package com.acm.lico.Solution146;

import java.util.HashMap;

/**
 * LRUCache class
 *
 * @author 谢小平
 * @date 2020-08-10
 */
public class LRUCache {
	private  HashMap<Integer,Node> hashMap;
	private int capacity;
	private Cache cache;
	public LRUCache(int capacity) {
		hashMap = new HashMap<>();
		cache = new Cache();
		this.capacity = capacity;
	}

	public int get(int key) {
		if(!hashMap.containsKey(key)) {
			return -1;
		}
		int val ;
		put(key,val = hashMap.get(key).val );
		return val;
	}

	public void put(int key, int value) {
		Node x = new Node(key, value);
		if(hashMap.containsKey(key)) {
			cache.remove(hashMap.get(key));
		} else {
			if(cache.size() == capacity) {
				Node last = cache.removeLast();
				hashMap.remove(last.key);
			}
		}
		cache.addFirst(x);
		hashMap.put(key,x);
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(1,1);
		lruCache.put(2,2);
		lruCache.get(1);
		lruCache.put(3,3);
		lruCache.get(2);
		lruCache.put(4,4);
		lruCache.get(1);
		lruCache.get(3);
		lruCache.get(4);
	}
}

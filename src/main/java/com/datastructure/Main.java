package com.datastructure;

import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 数据结构 class
 *
 * @author 谢小平
 * @date 2020-03-20
 */
public class Main {
    public static void main(String[] args) {
        String key = "xxp";
        System.out.println(key.hashCode());
        System.out.println(hash(key));
        TreeMap treeMap = new TreeMap();
        treeMap.put("xxp","2");
        treeMap.put("xxp","2");

        Integer t = 100000000>>>16;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        if(atomicBoolean.compareAndSet(true,true)) {
            System.out.println("true - > false");
        } else {
            System.out.println("" + atomicBoolean.get());
        }

        System.out.println("" + atomicBoolean.get());

//        System.out.println(AtomicLong);
//        ConcurrentHashMap
    }
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}

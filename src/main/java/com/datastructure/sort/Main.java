package com.datastructure.sort;


import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Main class
 *
 * @author 谢小平
 * @date 2020-03-23
 */
public class Main {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("xxp","1");
        hashMap.put("xxd","2");
        hashMap.put(null,"22");
        System.out.println(hashMap.toString());
    }
}

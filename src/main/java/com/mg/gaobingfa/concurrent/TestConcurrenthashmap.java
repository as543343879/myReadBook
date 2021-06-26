package com.mg.gaobingfa.concurrent;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TestConcurrenthashmap class
 *
 * @author 谢小平
 * @date 2018/11/9
 */
public class TestConcurrenthashmap {
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(2);
        HashMap hashMap = new HashMap(2);
    }

    @Test
    public void test1() {
        System.out.println( ((15 + 7)&-8) );
    }

    @Test
    public void test2() {
        System.out.println(2 & -2);
        int test = 0x80000001;
//        System.out.println(Integer.valueOf(single + "", 2));
        System.out.println(Integer.toHexString(test));
    }
}

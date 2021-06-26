package com.test;

import java.util.HashSet;

/**
 * TestSet class
 *
 * @author 格林
 * @date 2021-06-01
 */
public class TestSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
//        Object
        System.out.println(set.contains("a"));

    }
}

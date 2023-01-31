package com.jdk8.stringtest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Test01 class
 *
 * @author 谢小平
 * @date 2023/1/31
 */
public class Test01 {
    public static void main(String[] args) {
        String str = "1,2,3,";
        String[] strings = str.split(",");

        System.out.println(Arrays.toString(strings));

        String[] split = str.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(split));
    }
}

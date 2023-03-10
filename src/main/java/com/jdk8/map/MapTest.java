package com.jdk8.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * MapTest class
 *
 * @author 谢小平
 * @date 2023/3/8
 */
public class MapTest {

    @Test
    public void test1() {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer putValue = map.put(1, 1);
        System.out.println(putValue);
    }
}

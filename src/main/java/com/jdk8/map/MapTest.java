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
        map.put(4, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(6, 1);
        map.put(1, 1);
        Thread thread = new Thread(() -> {
            for (int i = 100; i < 200; i++) {
                map.put(i, i);
            }
        }, "thread");
        thread.start();


        Thread thread1 = new Thread(() -> {
            Integer integer = map.get(6);
            System.out.println(integer);
        }, "thread2");
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("xxp");
    }
}

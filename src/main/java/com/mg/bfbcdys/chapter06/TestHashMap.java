package com.mg.bfbcdys.chapter06;

import org.junit.Test;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * TestHashMap class
 *
 * @author 谢小平
 * @date 2019/9/17
 */
public class TestHashMap {
        public static void main(String[] args) {
            final HashMap<String,String> map = new HashMap<>(2);
            try {
                Thread t = new Thread(()->{
                    for(int i = 0 ; i < 10000; i ++) {
                        new Thread( ()->{
                            map.put(UUID.randomUUID().toString(),"");
                        },"ftf" + i).start();
                    }
                },"ftf");
                t.start();
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(map.size());
        }
    @Test
    public void test2() {
//        ConcurrentHashMap
//        ConcurrentLinkedQueue
//        ArrayBlockingQueue
        }
}

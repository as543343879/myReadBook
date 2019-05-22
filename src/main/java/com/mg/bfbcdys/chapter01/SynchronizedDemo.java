package com.mg.bfbcdys.chapter01;

/**
 * SynchronizedDemo class
 *
 * @author 谢小平
 * @date 2019/4/24
 */
public class SynchronizedDemo {
    private String strd;
    private static String strs;
    public synchronized void test1() {
        strd = "1";
        strs = "1";
        System.out.println("111");
    }

    public static synchronized void test2() {
        strs = "1";
        System.out.println("12211");
    }

    public   void test3() {
      synchronized (strd) {
            strd = "2";
            strs = "2";
            System.out.println("12211");
        }
    }
}

package com.mg.bfbcdys.chapter02;

/**
 * synchronizedEXample class
 *
 * @author 格林
 * @date 2020-07-30
 */
public class SynchronizedEXample {
    static volatile int i = 0;
    static  Object o = new Object();
    public static synchronized void method1(){
       synchronized (SynchronizedEXample.class) {
           i++;
       }
    }
    public static synchronized void method2(){
        synchronized (o) {
            i++;
        }
    }
}

package com.mg.bfbcdys.chapter03;

/**
 * VolatileTest class
 *
 * @author 谢小平
 * @date 2019/9/6
 */
public class VolatileTest {
    public static volatile boolean t = true;
    public static String str = "1";

    public static void main(String[] args) {
        str = "2";
        t =false;
        str = "3";
        if(t == false) {
            str = "4";
        }
    }
}

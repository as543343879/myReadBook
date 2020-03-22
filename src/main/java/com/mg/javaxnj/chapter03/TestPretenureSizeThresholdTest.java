package com.mg.javaxnj.chapter03;


/**
 * TestPretenureSizeThresholdTest class
 *
 * @author 谢小平  -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * @date 2019/4/26
 */
public class TestPretenureSizeThresholdTest {
    public static  final  int _1MB = 1024 * 1024;
    public static void main(String[] args) {
//        {
//            byte[] bytes;
//            bytes = new byte[7 * _1MB];
//            bytes = null;
//        }
        byte[] bytes;
        bytes = new byte[9 * _1MB];
//        bytes = null;

        byte[] bytes2;
        bytes2 = new byte[4 * _1MB];
        byte[] bytes3;
        bytes3 = new byte[4 * _1MB];
    }

//    private static void testPretenureSizeThreshold() {
//        byte[] bytes;
//        bytes = new byte[4 * _1MB];
//    }

}

package com.mg.javaxnj.chapter03;

/**
 * TestTenuringThreshold class
 *
 * @author 谢小平
 * @date 2019/4/26
 */
public class TestTenuringThreshold {
    public static  final  int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3;
        allocation1 =  new byte[_1MB / 2];
//        allocation2 = new byte[4 * _1MB];
        allocation2 = new byte[ _1MB * 4];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
        System.out.println(allocation1);
    }

    /**
     *  VM : -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1/15
     */
    static void testTenuringThreshold(){
        {
            byte[] allocation1,allocation2,allocation3;
            allocation1 =  new byte[_1MB / 4];
//        allocation2 = new byte[4 * _1MB];
            allocation2 = new byte[ _1MB * 4];
            allocation3 = new byte[4 * _1MB];
            allocation3 = null;
            allocation3 = new byte[4 * _1MB];
        }
    }

}

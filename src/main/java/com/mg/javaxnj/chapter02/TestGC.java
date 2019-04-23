package com.mg.javaxnj.chapter02;

import static com.mg.javaxnj.chapter02.DirectMemoryOOM._1MB;

/**
 * TestGC class
 * VM 参数 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @author 谢小平
 * @date 2018/12/7
 */
public class TestGC {
    // M 参数 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
    public static void testGC() {
        byte[] bytes1,bytes2,bytes3,bytes4;
        bytes1 = new byte[2 * _1MB];
        bytes2 = new byte[2 * _1MB];
        bytes3 = new byte[2 * _1MB];
        bytes4 = new byte[4 * _1MB];
    }
    // M 参数 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
    public static void testPretrnureSizeThresholdGC() {
        byte[] bytes1,bytes2,bytes3,bytes4;
        bytes1 = new byte[2 * _1MB];
        bytes2 = new byte[2 * _1MB];
        bytes3 = new byte[2 * _1MB];
        bytes4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
//        testGC();
        testPretrnureSizeThresholdGC();
    }

}

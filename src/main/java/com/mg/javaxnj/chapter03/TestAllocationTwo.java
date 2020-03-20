package com.mg.javaxnj.chapter03;

import static com.mg.javaxnj.chapter02.DirectMemoryOOM._1MB;

/**
 * TestAllocation class
 *
 * @author 谢小平 -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @date 2019/4/26
 */
public class TestAllocationTwo {
    public static void main(String[] args) {
        testAllocation();
    }
    public  static  void testAllocation() {
        byte[]  bytes1,bytes2,bytes3,bytes4;
        bytes1 = new byte[2 * _1MB];
        bytes2 = new byte[2 * _1MB];
        bytes3 = new byte[2 * _1MB];
        bytes4 = new byte[4 * _1MB];
    }
}

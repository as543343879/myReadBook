package com.mg.javaxnj.chapter04;

import java.util.ArrayList;
import java.util.List;

/**
 * ITest class
 *
 * @author 谢小平
 * @date 2018/11/6
 */

public class ITest {
    static class OOMobject{
      public byte[] placeholder = new byte[64 * 1024];
    }
    public static void fileHeap(int num) throws InterruptedException {
        List<OOMobject> list = new ArrayList<>();
        for(int i = 0; i < num; i ++) {
            Thread.sleep(50);
            list.add(new OOMobject());
        }
        System.gc();
    }
    public static void main(String[] args) throws InterruptedException {
        fileHeap(1000);
    }
}

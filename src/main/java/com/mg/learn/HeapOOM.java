package com.mg.learn;

import java.util.ArrayList;

/**
 * HeapOOM class
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=E:\heapdump
 * @author 谢小平
 * @date 2019/5/23
 */
class OOMObject {
    byte[] bytes;
    public OOMObject(byte[] bytes) {
        this.bytes = bytes;
    }
}
public class HeapOOM {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();
        for(int i = 0 ; i < 1024; i ++) {
            list.add(new OOMObject(new byte[_1MB]  ));
        }
    }
}

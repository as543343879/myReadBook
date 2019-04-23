package com.mg.javaxnj.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * HeapOOM class
 *  VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author 谢小平
 * @date 2018/12/7
 */
public class HeapOOM {
    static class OOMObject {

    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}

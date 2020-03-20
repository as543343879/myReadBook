package com.datastructure;

import java.util.HashMap;

/**
 * 数据结构 class
 *
 * @author 谢小平
 * @date 2020-03-20
 */
public class Main {
    public static void main(String[] args) {

    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}

package com.mg.javaxnj.chapter02;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.List;

/**
 * DirectMemoryOOM class -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * @author 谢小平
 * @date 2018/9/13
 */
public class DirectMemoryOOM {
    public static  final  int _1MB = 1024 * 1024;
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        int i = 0;
        while (true) {
            unsafe.allocateMemory(_1MB);
            System.out.println(++i);
        }
    }


}

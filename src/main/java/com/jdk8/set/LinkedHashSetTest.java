package com.jdk8.set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * LinkedHashSetTest class
 *
 * @author 谢小平
 * @date 2023/2/21
 */
public class LinkedHashSetTest {
    @Test
    public void test1() {
        LinkedHashSet<Integer> set = new LinkedHashSet();
        set.add(1);
        set.add(2);
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        set.addAll(list);
        set.forEach(System.out::println);
    }
}

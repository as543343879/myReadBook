package com.mg.java8.chapter05;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Main class
 *
 * @author 谢小平
 * @date 2018/7/17
 */
public class Main {

    @Test
    public void test1() {
        List<Integer> numbers = Arrays.asList(1,2,2,3,4,5);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
        Integer i = 0;

    }
}


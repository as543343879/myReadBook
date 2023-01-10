package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * StreamTest class
 *
 * @author 谢小平
 * @date 2022/12/20
 */
public class StreamTest {
    public static void main(String[] args) {
        int[] dict = {1,2,3,4};
        List<Integer> res = Arrays.stream(dict).filter(e -> e == 0).mapToObj(e->Integer.valueOf(e)).collect(Collectors.toList());
    }
}

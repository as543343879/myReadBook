package com.jdk8.bit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class
 *
 * @author 谢小平
 * @date 2023/2/22
 */
public class Main {
    @Test
    public void test1() {
        int t = 0;
        System.out.println(Integer.toBinaryString(t));
        System.out.println(Integer.toBinaryString(t >> 1));

        System.out.println(0 ^ 0 >> 1);

    }

    @Test
    public void test3() {
        int t = 10;

        System.out.println( t + "---"  + Integer.toBinaryString(t));
        t = t >> 1;
        System.out.println( t + "---"  + Integer.toBinaryString(t));
        t = t >> 1;
        System.out.println( t + "---"  + Integer.toBinaryString(t));
    }

    @Test
    public void test2() {
        System.out.println(grayCode(2));
    }

    /**
     * g(i) = b(i+1) \oplus b(i),~~~~0 \le i \lt n
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n){
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            int t = (i >> 1) ^ i;
            System.out.println(Integer.toBinaryString(t));
            ret.add(t);
        }
        return ret;
    }
}

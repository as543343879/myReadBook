package com.jdk8.bit;

import org.junit.Test;

/**
 * AndTest class
 *
 * @author 谢小平
 * @date 2023/4/6
 */
public class AndTest {
    @Test
    public void test1(){
        int i  = 1 | 2 | 1;
        System.out.println(i);

        i  = 1 ^ 3 ^ 1;
        System.out.println(i);
    }
}

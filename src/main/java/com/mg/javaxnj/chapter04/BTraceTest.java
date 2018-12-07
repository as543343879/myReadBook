package com.mg.javaxnj.chapter04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BTraceTest class
 *
 * @author 谢小平
 * @date 2018/11/7
 */
public class BTraceTest {
    public int add(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) throws IOException {
        BTraceTest test = new BTraceTest();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 10; i ++) {
            bufferedReader.readLine();
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(test.add(a , b));
        }
    }
}

package com.mg.javaxnj.chapter02;

import org.junit.Test;

/**
 * RuntimeConstantPoolOOM class
 *
 * @author 谢小平
 * @date 2018/9/13
 */
public class RuntimeConstantPoolOOM
{

    @Test
    public void test1 () {
            String s = new String("1");
            s.intern();
            String s2 = "1";
            System.out.println(s == s2);

            String s3 = new String("1") + new String("1");
            s3.intern();
            String s4 = "11";
            System.out.println(s3 == s4);
    }
    public static void main(String[] args) throws InterruptedException {
//        String s = new String("1");
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
//        String str = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str.intern() == str);
//
//        String str1 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str1.intern() == str1);
//        String str2 = new StringBuilder("in").append("t").toString();
//        System.out.println(str2.intern() == str2);
    }
}


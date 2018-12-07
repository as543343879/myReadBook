package com.mg.javaxnj.chapter02;

import org.omg.CORBA.StringHolder;

/**
 * RuntimeConstantPoolOOM class
 *
 * @author 谢小平
 * @date 2018/9/13
 */
public class RuntimeConstantPoolOOM
{
    public static void main(String[] args) {
        String str = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str.intern() == str);

        String str1 = new StringBuilder("ja").append("va").toString();
        System.out.println(str1.intern() == str1);
    }
}

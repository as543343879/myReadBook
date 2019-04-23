package com.mg.javaxnj.chapter07;

/**
 * ConstClass class
 *
 * @author 谢小平
 * @date 2018/12/20
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }
    public static  final  String HELLOWORLD = "hello world";
}

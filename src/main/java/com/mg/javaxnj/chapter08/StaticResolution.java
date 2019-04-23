package com.mg.javaxnj.chapter08;

import java.io.Serializable;

/**
 * StaticResolution class
 *
 * @author 谢小平
 * @date 2018/12/27
 */
public class StaticResolution {
    public static void sayHello() {
        System.out.println("hello World");
    }
    public static void main(String[] args) {
//        Serializable
//        Character
        StaticResolution.sayHello();
    }
}

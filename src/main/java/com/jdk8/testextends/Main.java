package com.jdk8.testextends;

/**
 * Main class
 *
 * @author 谢小平
 * @date 2021/7/30
 */
public class Main {
    public static void main(String[] args) {
        Child child = new Child( "parent","child");
        System.out.println(child.getAttr());
    }
}

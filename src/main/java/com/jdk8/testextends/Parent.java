package com.jdk8.testextends;

/**
 * Parent class
 *
 * @author 谢小平
 * @date 2021/7/30
 */
public class Parent {
    public Parent(String attr) {
        this.attr = attr;
    }

    private String attr;

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }
}

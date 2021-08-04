package com.jdk8.testextends;

/**
 * Child class
 *
 * @author 谢小平
 * @date 2021/7/30
 */
public class Child extends Parent {

    private String attr;

    public Child(String attr, String childAttr) {
        super(attr);
        this.attr = childAttr;
    }

    @Override
    public String getAttr() {
        super.getAttr();
        return attr;
    }

    @Override
    public void setAttr(String attr) {
        this.attr = attr;
    }
}

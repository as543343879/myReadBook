package com.mg.gaobingfa;

/**
 * IntHandler class
 *
 * @author 谢小平
 * @date 2018/7/13
 */
@FunctionalInterface
public interface IntHandler {
    void handle(int i);
    @Override
    boolean equals(Object obj);
}

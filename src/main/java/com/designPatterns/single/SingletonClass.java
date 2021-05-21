package com.designPatterns.single;

/**
 * SingletonClass class
 *
 * @author 格林
 * @date 2021-05-18
 */
public class SingletonClass {

    private static class SingletonInnerClass {
        private static SingletonClass singletonClass = new SingletonClass();
    }

    public static SingletonClass getInstance() {
        return SingletonInnerClass.singletonClass;
    }
}

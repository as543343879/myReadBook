package com.designPatterns.single;

/**
 * SingletonEnum class
 *
 * @author 格林
 * @date 2021-05-18
 */
public enum  SingletonEnum {
    XXP("xxp");

    private String name;

    SingletonEnum(String name) {
        this.name = name;
    }

}

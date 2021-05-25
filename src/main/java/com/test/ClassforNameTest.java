package com.test;

/**
 * ClassforNameTest class
 *
 * @author 格林
 * @date 2021-05-23
 */
public class ClassforNameTest {
    public static void main(String[] args) {
        try {
            Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

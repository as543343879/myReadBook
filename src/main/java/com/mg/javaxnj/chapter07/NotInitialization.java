package com.mg.javaxnj.chapter07;

/**
 * NotInitialization class
 * JVM 参数 -XX:+TraceClassLoading
 * @author 谢小平
 * @date 2018/12/20
 */
public class NotInitialization {
    public static void main(String[] args) {
//        System.out.println(SupClass.value);
//        SupClass[] sca = new SupClass[10];
        System.out.println(ConstClass.HELLOWORLD);
    }

}

package com.jdk8.reflect;
// v0版本

import java.lang.reflect.Method;

public class TestV0 {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("com.jdk8.reflect.TestV0");
        Method method = klass.getMethod("target", int.class);
        method.invoke(null, 0);
    }
}

//# 不同版本的输出略有不同，这里我使用了Java 10。
//$ java Test
//java.lang.Exception: #0
//        at Test.target(Test.java:5)
//        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl .invoke0(Native Method)
// a      t java.base/jdk.internal.reflect.NativeMethodAccessorImpl. .invoke(NativeMethodAccessorImpl.java:62)
// t       java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.i .invoke(DelegatingMethodAccessorImpl.java:43)
//        java.base/java.lang.reflect.Method.invoke(Method.java:564)
//  t        Test.main(Test.java:131
package com.jdk8.reflect;

// v4版本

import java.lang.reflect.Method;

// 在运行指令中添加如下两个虚拟机参数：
// -Djava.lang.Integer.IntegerCache.high=128
// -Dsun.reflect.noInflation=true 在反射调用一开始便会直接生成动态实现，而不会使用委派实现或者本地实现。
public class TestV04 {
    public static void target(int i) {
        // 空方法
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("com.jdk8.reflect.TestV04");
        Method method = klass.getMethod("target", int.class);
        method.setAccessible(true);  // 关闭权限检查

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null, 128);
        }
    }
}

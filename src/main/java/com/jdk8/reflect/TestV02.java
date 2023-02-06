package com.jdk8.reflect;
// v2版本

import java.lang.reflect.Method;

public class TestV02 {
  public static void target(int i) {
    // 空方法
  }

  public static void main(String[] args) throws Exception {
    Class<?> klass = Class.forName("com.jdk8.reflect.TestV02");
    Method method = klass.getMethod("target", int.class);

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

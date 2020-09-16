package com.test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Foo {
  static boolean boolValue;
  public static void main(String[] args) {
    boolValue = true; // 将这个true替换为2或者3，再看看打印结果
    if (boolValue) System.out.println("Hello, Java!");
    if (boolValue == true) System.out.println("Hello, JVM!");


  }
}
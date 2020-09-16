package com.mg.bfbcdys.chapter02;

import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassLayout class
 *
 * @author 谢小平
 * @date 2020-08-13
 */

class A {
	long l;
	int i;
}

class B extends A {
	long l;
	int i;
}
public class ClassLayout {
	public static void main(String[] args) {
		System.out.println(8 % 5);
		System.out.println(8 & 5);
		System.out.println(org.openjdk.jol.info.ClassLayout.parseClass(B.class).toPrintable());
		System.out.println(org.openjdk.jol.info.ClassLayout.parseClass(Long.class).toPrintable());
	}
}

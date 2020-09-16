package com.test;

/**
 * StaticTest2 class
 *
 * @author 谢小平
 * @date 2020-09-02
 */
public class StaticTest2 {
	static class Parent {
		static {
			A = 2;
		}
		public static int A = 1;
	}

	static class Sub extends Parent {
		public static int B = A;
	}

	public static void main(String[] args) {
		System.out.println(Sub.B);
	}
}

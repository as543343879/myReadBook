package com.jdk8;

/**
 * StringTest class
 *
 * @author 谢小平
 * @date 2020-10-13
 */

public class StringTest {
	private int i = test2();

	public StringTest() {
		System.out.println("StringTest");
	}


	private int i2 = test3();

	public int test2() {
		System.out.println("test2");
		return 1;
	}

	public int test3() {
		System.out.println("test3");
		return 1;
	}

	public static void main(String[] args) {
//		StringTest stringTest = new StringTest();
//	    System.out.println("12312".hashCode());
		String x = "ab",y = "a"+"b";
		System.out.println(x==y);
	}
}

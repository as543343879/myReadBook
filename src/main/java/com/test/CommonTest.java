package com.test;

import org.junit.Test;

/**
 * CommonTest class
 *
 * @author 谢小平
 * @date 2020-08-12
 */
public class CommonTest {
	@Test
	public void test1() {
		A a = new A();
		a.show();
		A b = new B();
		b.show();

		B c = new B();
		c.show();
	}
}

class A{
	public  static void show(){
		System.out.println(" Static Method of A");
	}
}
class B extends A{
	public static void show(){
		System.out.println("Static Method of B");

	}
}

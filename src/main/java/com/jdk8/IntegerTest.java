package com.jdk8;

/**
 * IntegerTest class
 *
 * @author 谢小平
 * @date 2020-09-30
 */
public class IntegerTest {
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(0x01010101));
		System.out.println(Integer.bitCount(121));
		System.out.println(swar(121));
		System.out.println(Integer.toBinaryString(121));



	}

	public static int swar(int i) {
		//第一步
		System.out.println(Integer.toBinaryString(i & 0x55555555));
		System.out.println(Integer.toBinaryString(((i >> 1) & 0x55555555)));
		i = (i & 0x55555555) + ((i >> 1) & 0x55555555);

		System.out.println(Integer.bitCount(i));
		System.out.println(Integer.toBinaryString(i));

		//第二步
		i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
		//第三步
		i = (i & 0x0f0f0f0f) + ((i >> 4) & 0x0f0f0f0f);
		//第四步
		i = (i * (0x01010101) >> 24);
		return i;

	}
}

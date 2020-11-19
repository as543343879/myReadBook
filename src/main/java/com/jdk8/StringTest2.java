package com.jdk8;

/**
 * StringTest2 class
 *
 * @author 谢小平
 * @date 2020-11-19
 */
public class StringTest2 {
	public static void main(String[] args) {
		String s = new String("111");
		s.intern();
		String s2 = "111";
		System.out.println(s == s2);

		String s3 = new String("1") + new String("1");
		s3  = new StringBuilder("1").append("1").toString();
		s3.intern();
		String s4 = "11";
		System.out.println(s3 == s4);

		char[] strs = {'a','b'};
		String s5 = new String(strs,0,2);
		s5.intern();
		String s6 = "ab";
		System.out.println(s5 == s6);

	}
}

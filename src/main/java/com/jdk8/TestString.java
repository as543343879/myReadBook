package com.jdk8;

import org.junit.Test;

/**
 * TestString class
 *
 * @author 谢小平
 * @date 2020-09-15
 */
public class TestString {
	public static void main(String[] args) {
		String s0="kvill";
		String s1="kvill";
		String s2="kv" + "ill";
		System.out.println( s0==s1 );
		System.out.println( s0==s2 );

		String s11=new String("kvill");

		String s22="kv" + new String("ill");

		System.out.println( s0==s11 );

		System.out.println( s0==s22 );

		System.out.println( s11==s22 );
	}

	@Test
	public void test1() {
		String s0= "kvill";
		System.out.println(s0.hashCode());
		String s1=new String("kvill");

		String s2=new String("kvill");

		System.out.println( s0==s1 );

		System.out.println( "**********" );

		String intern = s1.intern();
		System.out.println(intern.hashCode());

		s2=s2.intern(); //把常量池中"kvill"的引用赋给s2

		System.out.println( s0==s1);

		System.out.println( s0==s1.intern() );

		System.out.println( s0==s2 );
		String s3 = new String("kvil") +  new String("l");
		System.out.println(s3 == s0);


		String ab = new String("dnsdfnjew")+new String("dnjsfne");
		ab.intern();
		String cd = "dnsdfnjewdnjsfne";
		System.out.println(ab==cd);//true 第二步

	}
}

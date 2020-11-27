package com.jdk8;

import java.lang.ref.WeakReference;

/**
 * WeakReferenceTest class
 *
 * @author 谢小平
 * @date 2020-11-24
 */
public class WeakReferenceTest {
		public static void main(String[] args) {
		WeakReference<String> weakReferenceString = new WeakReference("xxp");
			String s = weakReferenceString.get();
			System.out.println(s);
			System.gc();
			System.out.println(s);
			s = null;
			System.gc();
			System.out.println(s);
		}
}

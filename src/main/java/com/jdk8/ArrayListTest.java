package com.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ArrayListTest class
 *
 * @author 谢小平
 * @date 2020-09-09
 */
public class ArrayListTest {
	public static void main(String[] args) {
		List t = new ArrayList();
		System.out.println(t);
	}

	@Test
	public void  test1() {
		List list = new CopyOnWriteArrayList();
		System.out.println(list);
//		list = Collections.synchronizedList()
	}

	@Test
	public void test2() {
		ArrayList<String> list = new ArrayList();

		list.add(2,"22" );
		System.out.println(list.get(2));
	}
}

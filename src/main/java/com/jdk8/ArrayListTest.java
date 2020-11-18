package com.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
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
	}

	@Test
	public void  test1() {
		List list = new CopyOnWriteArrayList();
//		list = Collections.synchronizedList()
	}
}

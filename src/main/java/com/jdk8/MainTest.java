package com.jdk8;

import java.util.ArrayList;
import java.util.Collections;

/**
 * MainTest class
 *
 * @author 谢小平
 * @date 2020-11-03
 */
public class MainTest {
	public static void main(String[] args) {
		Collections.synchronizedList(new ArrayList<>()) ;
	}
}

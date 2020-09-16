package com.jdk8;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * MapTest class
 *
 * @author 谢小平
 * @date 2020-09-08
 */
class Stu{
	private String id;
	private String name;

	public Stu(String id, String name) {
		this.id = id;
		this.name = name;
	}
}
public class MapTest {
	@Test
	public void testHashSet() {
		HashSet set = new HashSet();
		set.add(new Stu("1","aa"));
		set.add(new Stu("1","aa2"));
		System.out.println(set.size());
	}

	@Test
	public void testHashHash() {
		HashMap map = new HashMap();
		map.put(new Stu("1","aa"),"213");
		map.put(new Stu("1","aa"),"213");
		System.out.println(map.size());
	}
	public static void main(String[] args) {
		LinkedHashMap linkedHashMap = new LinkedHashMap();
		linkedHashMap.put("xxp","xxp");
		System.out.println(linkedHashMap.get("xxp"));

	}
}

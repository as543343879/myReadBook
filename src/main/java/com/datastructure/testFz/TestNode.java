package com.datastructure.testFz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TestNode class
 *
 * @author 谢小平
 * @date 2020-11-18
 */
public class TestNode {
	  static  List<Node> newList = new ArrayList<>(100);
	 static List<Node> list ;
	public static void main(String[] args) {
	     list = new ArrayList(100);
		list.add(new Node(5,55));
		list.add(new Node(4,44));
		list.add(new Node(3,5));
		list.add(new Node(2,4));
		list.add(new Node(0,3));
		list.add(new Node(0,2));
//		list.add(new Node(-1,0));
//		parentList.add(new Node(0,3));
		newList.add(new Node(-1,0));
		changeData(",0,");
		newList.forEach(System.out::println);
	}

	public static  void changeData(String parentStr) {
		if(list == null || list.size() == 0) {
			return ;
		}
		if(parentStr == null || parentStr.length() == 0) {
			return ;
		}
		StringBuilder newString = new StringBuilder();
		Iterator<Node> iterator = list.iterator();
		while (iterator.hasNext()) {
			Node next = iterator.next();
			if( parentStr.indexOf("," +next.getPid() +  ",") != -1) {
				newList.add(next);
				newString.append(","+next.getChild());
				iterator.remove();
			}
		}
		newString.append(",");
		changeData(newString.toString());

	}




}

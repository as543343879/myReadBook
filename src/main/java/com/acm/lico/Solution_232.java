package com.acm.lico;

import com.acm.lico.p232.MyQueue;

import java.util.Stack;

/**
 * Solution_232 class
 *
 * @author 谢小平
 * @date 2020-07-30
 */
public class Solution_232 {
	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		myQueue.push(4);
		myQueue.push(5);
		while (!myQueue.empty()) {
			System.out.println(myQueue.pop());
		}
	}

}

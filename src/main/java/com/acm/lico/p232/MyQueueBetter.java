package com.acm.lico.p232;

import java.util.Stack;

public  class MyQueueBetter {
	public static void main(String[] args) {
		MyQueueBetter myQueue = new MyQueueBetter();
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		myQueue.push(4);
		myQueue.push(5);
		while (!myQueue.empty()) {
			System.out.println(myQueue.pop());
		}
	}
		Stack<Integer> stackIn= new Stack<>();
		Stack<Integer>stackIn2 =new Stack<>();
		/** Initialize your data structure here. */
		public MyQueueBetter() {
		}

		/** Push element x to the back of queue. */
		public void push(int x) {

			if(stackIn.isEmpty()) {
				while (!stackIn2.isEmpty()) {
					stackIn.push( stackIn2.pop());
				}
			}
			stackIn.push(x);
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			if(stackIn2.isEmpty()) {
				while (!stackIn.isEmpty()) {
					stackIn2.push(stackIn.pop());
				}
			}
			return stackIn2.pop();
		}

		/** Get the front element.  */
		public int peek() {
			if(stackIn2.isEmpty()) {
				while (!stackIn.isEmpty()) {
					stackIn2.push(stackIn.pop());
				}
			}
			return stackIn2.peek();
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			if(stackIn.isEmpty() && stackIn2.isEmpty()) {
				return true;
			}
			return false;
		}
}
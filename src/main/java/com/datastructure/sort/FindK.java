package com.datastructure.sort;

import java.util.PriorityQueue;

/**
 * FindK class
 *
 * @author 谢小平
 * @date 2020-09-11
 */
public class FindK {

	public static int  findk(int[] ints, int k){
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i = 0; i < k ; i ++) {
			queue.offer(ints[i]);
		}

		for(int i = k; i < ints.length; i ++) {
			if(ints[i] > queue.peek()) {
				queue.poll();
				queue.offer(ints[i]);
			}
		}
		return queue.peek();
	}
	public static void main(String[] args) {
	 	int[] arr = {1,7,6,5,4,3,2};
	 	System.out.println(findk(arr,2));
	}
}

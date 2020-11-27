package com.datastructure.testFz;

import lombok.Data;

/**
 * Node class
 *
 * @author 谢小平
 * @date 2020-11-18
 */
@Data
public class Node {
	private int pid;
	private int child;

	public Node(int pid, int child) {
		this.pid = pid;
		this.child = child;
	}
}

package com.acm.lico.Solution146;

/**
 * Cache class
 *
 * @author 谢小平
 * @date 2020-08-10
 */
public class Cache {
	private Node head;
	private Node tail;
	private int size;

	public void addFirst(Node node) {
		if(head == null) {
			head = tail =node;
		} else {
			Node n = head;
			head = node;
			node.next = n;
			n.pre = node;
		}
		size ++;
	}

	public void remove(Node node) {
		if(head == node && tail == node) {
			head = tail = null;
		} else if(head == node) {
			node.next.pre = null;
			head = head.next;
		} else if(tail == node) {
			tail = tail.pre;
			node.pre.next = null;
		} else {
			node.pre.next = node.next;
			node.next.pre = node.pre;

		}
		size -- ;
	}

	public Node removeLast() {
		Node node = tail;
		remove(tail);
		return node;
	}

	public int size() {
		return size;
	}
}

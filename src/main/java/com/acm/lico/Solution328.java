package com.acm.lico;

/**
 * Solution328 class
 *
 * @author 谢小平
 * @date 2020-07-10
 */
public class Solution328 {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	class Solution {
		  public ListNode oddEvenList(ListNode head) {
			  if (head == null) {
				  return null;
			  }
			  ListNode tail = head, evenHead = head.next, evenTail = evenHead;

			  while (evenTail != null && evenTail.next != null) {
				  tail = tail.next = evenTail.next;
				  evenTail =  evenTail.next =  tail.next;
			  }
			  tail.next = evenHead;
			return head;
		  }
	  }
}

package com.acm.lico;

/**
 * Solution_25 class
 *
 * @author 谢小平
 * @date 2020-07-29
 */
public class Solution_25 {


    public static void main(String[] args) {
//	     class ListNode {
//		    int val;
//		     ListNode next;
//		    ListNode(int x) { val = x; }
//	    }
        ListNode listNode = new ListNode(1);
	    ListNode head = listNode;
	    ListNode listNode2 = new ListNode(2);
	    listNode.next = listNode2;
	    listNode= listNode.next;
	     listNode2 = new ListNode(3);
	    listNode.next = listNode2;
	    listNode= listNode.next;
	     listNode2 = new ListNode(4);
	    listNode.next = listNode2;
	    listNode= listNode.next;
	    listNode2 = new ListNode(5);
	    listNode.next = listNode2;
	    listNode= listNode.next;

	    print(head);
	    ListNode listNode1 = reverse2(head);
	    print(listNode1);
//	    Solution_25 solution_25 = new Solution_25();
//	    ListNode listNode1 = solution_25.reverseKGroup(head, 2);
//	    print(listNode1);
    }

    public static ListNode  reverse2(ListNode head){
	    ListNode t;
	    ListNode pre = null; // 之前已经取的
	    head = head.next;
	    while (head != null) {
	    	 t = head.next;
		    head.next = pre;
		    pre = head;
		    head = t;
	    }
	    return pre;
    }

    public static void  print(ListNode head) {
    	StringBuilder stringBuilder = new StringBuilder();
    	while (head!= null) {
		    stringBuilder.append(head.val + "->");
		    head = head.next;
	    }
    	System.out.println(stringBuilder.toString());
    }



	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode newHead = new ListNode(0);
		ListNode pre = newHead; //  待反转的前驱
	  	int i;
		newHead.next = head;
		ListNode end = newHead; //  待反转的最后一个节点
		do {
	  		i = 1;
			while (i <= k && end.next !=  null) {
				end = end.next;
				i ++;
			}
			i -- ;
			if(i == k) {
				ListNode start = pre.next;
				ListNode reverse = reverse(pre, end, k);
				pre.next = reverse;
				pre = start;
				end = start;
				// 不足k个
			} else {
				break;
			}


	    } while ( end != null);
	  	return newHead.next;
	}
	public ListNode   reverse(ListNode pre, ListNode end, int k) {
		ListNode start = pre.next;
		if(end == null) {
			System.out.println(end.val);
		}
		ListNode t, ipre = end.next;
		while (k > 0) {
			t = start.next;
			start.next = ipre;
			ipre = start;
			start = t;
			k--;
		}
//		pre.next = start;
		return ipre;
	}

}


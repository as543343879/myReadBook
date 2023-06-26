package com.acm.lico; /**
 25 ,K 个一组翻转链表
 //给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 //
 // k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 //
 // 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：head = [1,2,3,4,5], k = 2
 //输出：[2,1,4,3,5]
 //
 //
 // 示例 2：
 //
 //
 //
 //
 //输入：head = [1,2,3,4,5], k = 3
 //输出：[3,2,1,4,5]
 //
 //
 //
 //提示：
 //
 //
 // 链表中的节点数目为 n
 // 1 <= k <= n <= 5000
 // 0 <= Node.val <= 1000
 //
 //
 //
 //
 // 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 //
 //
 //
 //
 // Related Topics 递归 链表 👍 2055 👎 0

 **/
/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询
 自己思路：
 时间复杂度 O(N)
 空间复杂度 O(1)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 1. 使用哨兵节点 newHead
 2. 从头开始遍历，每次遍历k个节点，然后反转，然后连接到 newHead 后面, 如果小于k，直接连接到 newHead 后面
 3. 重复上述步骤2，直到结束
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:41.9 MB,击败了40.04% 的Java用户
 */

public class Solution2503 {
	public ListNode reverseKGroup(ListNode head, int k) {
		if( k == 1)
			return head;

		ListNode newHead = new ListNode(0);
		ListNode headNextK = head;
		ListNode temp = newHead;
		int count = 0;
		k --;
		while (headNextK != null && headNextK.next != null) {
			count ++;
			headNextK = headNextK.next;
			if( count == k) {
				count = 0;
				ListNode next = headNextK.next;
				headNextK.next = null;
				ListNode reverse = reverse(head);
				temp.next = reverse;
				temp = head;
				// 重新赋值 head 与 headNextK
				head = next;
				headNextK = head;
			}
		}
		if(head != null) {
			temp.next = head;
		}
		return newHead.next;
	}

	/**
	 *  反转列表
	 * @param head
	 * @return
	 */
	public ListNode reverse(ListNode head ) {
		ListNode pre = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = pre;
			pre  = head;
			head = next;
		}
		return pre;
	}


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
//	    ListNode listNode1 = reverse2(head);
//	    print(listNode1);
	    Solution2503 solution_25 = new Solution2503();
	    ListNode listNode1 = solution_25.reverseKGroup(head, 2);
	    print(listNode1);
    }




	public static void  print(ListNode head) {
		StringBuilder stringBuilder = new StringBuilder();
		while (head!= null) {
			stringBuilder.append(head.val + "->");
			head = head.next;
		}
		System.out.println(stringBuilder.toString());
	}

}


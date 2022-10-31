package com.acm.lico.linkedList; /**
 143 ,重排链表
 //给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 //
 //
 //L0 → L1 → … → Ln - 1 → Ln
 //
 //
 // 请将其重新排列后变为：
 //
 //
 //L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 //
 // 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 //
 //
 //
 // 示例 1：
 //
 //
 //
 //
 //输入：head = [1,2,3,4]
 //输出：[1,4,2,3]
 //
 // 示例 2：
 //
 //
 //
 //
 //输入：head = [1,2,3,4,5]
 //输出：[1,5,2,4,3]
 //
 //
 //
 // 提示：
 //
 //
 // 链表的长度范围为 [1, 5 * 10⁴]
 // 1 <= node.val <= 1000
 //
 //
 // Related Topics 栈 递归 链表 双指针 👍 1066 👎 0

 **/
/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 O(N)
 空间复杂度
 O(N)

 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 快慢指针，加栈
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:2 ms,击败了43.03% 的Java用户
 内存消耗:44 MB,击败了71.95% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public  class Solution143 {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        LinkedList<ListNode> stack = new LinkedList();
        while (slow !=null && slow.next != null) {
            fast = fast.next;
            slow = slow.next;
            if(slow != null) {
                slow = slow.next;
            }
        }
        slow = fast.next;
        fast.next = null;
        while (slow != null) {
            stack.addLast(slow);
            slow = slow.next;
        }

        fast = head;
        while (!stack.isEmpty()) {
            ListNode listNode = stack.pollLast();
            ListNode t = fast.next ;
            fast.next = listNode;
            listNode.next = t;
            fast = fast.next.next;
        }

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
        new Solution143().reorderList(node1);
        System.out.println(node1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

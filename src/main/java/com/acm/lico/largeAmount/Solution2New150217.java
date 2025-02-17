package com.acm.lico.largeAmount; /**
两数相加:2
2025-02-17 23:26:37
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 11063 👎 0

**/

//leetcode submit region begin(Prohibit modification and deletion)
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


/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度 O(N)
 空间复杂度 O(N)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。
    链表遍历; 使用一个哨兵节点；
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
     解答成功:
     执行耗时:1 ms,击败了100.00% 的Java用户
     内存消耗:43.5 MB,击败了57.13% 的Java用户
 */
class Solution2New150217 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int next = 0;
        ListNode preHead= new ListNode(0);
        ListNode head = preHead;
        while (l1 != null || l2 != null) {
            int temp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 :  l2.val) + next;
            next = temp / 10;
            temp = temp % 10;
            ListNode nowNode = new ListNode(temp);
            head.next = nowNode;
            head = nowNode;
            if(l1 != null) {
                l1 = l1.next;
            }
           if(l2 != null) {
               l2 = l2.next;
           }
        }
        if(next > 0) {
            ListNode nowNode = new ListNode(next);
            head.next = nowNode;
        }
        return preHead.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)o`

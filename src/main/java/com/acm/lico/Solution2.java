package com.acm.lico;

/**
 * Solution2 class
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-26
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        int carry = 0,sum;
        while (l1 != null || l2 != null) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            sum = value1 + value2 + carry;
            ListNode tNode = new ListNode(sum % 10);
            carry = sum / 10;
            pre.next = tNode;
            pre = pre.next;

            // 改成if 判断
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry == 1) {
            ListNode tNode = new ListNode(1);
            pre.next = tNode;
        }
        return head.next;
    }
}

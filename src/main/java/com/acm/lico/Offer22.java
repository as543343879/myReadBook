package com.acm.lico;

/**
 * Offer22 class
 * 剑指 Offer 22. 链表中倒数第k个节点
 *  输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * @author 格林
 * @date 2021-06-20
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode ihead = new ListNode(0,head);
        ListNode slow = ihead;
        ListNode fast = head;
        for(int i = 0; i < k; i ++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.next;
    }
}

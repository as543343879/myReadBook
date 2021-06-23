package com.acm.lico;

/**
 * Solution19 class
 * 19. 删除链表的倒数第 N 个结点
 *  给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @author 格林
 * @date 2021-06-20
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ihead = new ListNode(0,head);
        ListNode fastn = head;
        ListNode slow = ihead;
        for(int i = 0; i < n; i ++){
            fastn = fastn.next;
        }
        while (fastn != null) {
            slow = slow.next;
            fastn = fastn.next;
        }
        slow.next = slow.next.next;
        return ihead.next;

    }
}

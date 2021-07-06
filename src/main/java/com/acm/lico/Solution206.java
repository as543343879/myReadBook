package com.acm.lico;

/**
 * Solution206 class
 *
 * @author 格林
 * @date 2021-07-04
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode t = head.next;
            head.next = pre;
            pre = head;
            head = t;
        }
        return  head;
    }
}

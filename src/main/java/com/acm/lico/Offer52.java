package com.acm.lico;

/**
 * Offer52 class
 *
 * @author 格林
 * @date 2021-06-22
 */
public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curHeadA = headA;
        ListNode curHeadB = headB;
        while (curHeadA != curHeadB) {
           curHeadA = curHeadA == null ? headB : curHeadA.next;
           curHeadB = curHeadB == null ? headA : curHeadB.next;
        }
        return curHeadA;
    }
}

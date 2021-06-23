package com.acm.lico;

import java.util.Stack;

/**
 * Solution445 class
 * 445. 两数相加 II
 *
 *  给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * @author 格林
 * @date 2021-06-20
 */
public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int jinWei = 0;
        ListNode ans = null;
        while (!stack1.empty() || !stack2.empty()) {
            Integer t1 = stack1.empty() ? 0 : stack1.pop();
            Integer t2 = stack2.empty() ? 0 :stack2.pop();
            int sum = t1 + t2 + jinWei;
            int cur = sum % 10;
            jinWei = sum / 10;
            ListNode curNode = new ListNode(cur);
            curNode.next = ans;
            ans = curNode;
        }
        if(jinWei == 1)  {
            ListNode curNode = new ListNode(1);
            curNode.next = ans;
            ans = curNode;
        }
        return ans;
    }
}

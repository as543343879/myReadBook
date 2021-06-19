package com.acm.lico;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution02T02 class
 * 面试题 02.01. 移除重复节点
 * @author 格林
 * @date 2021-06-19
 */
public class Solution02T01 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        while (pre.next != null) {
            if(set.add(pre.next.val)) {
                pre = pre.next;
            } else {
                pre.next = pre.next.next;
            }
        }
        return head;
    }
}

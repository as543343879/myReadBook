package com.acm.lico;

import java.util.List;

/**
 * Solution206 class
 *https://leetcode.cn/problems/reverse-linked-list/
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * @author 格林
 * @date 2021-07-04
 */
public class Solution206 {
    /**
     * 28 / 28 个通过测试用例
     * 状态：通过
     * 执行用时: 0 ms
     * 内存消耗: 38.1 MB
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode t = head.next;
            head.next = pre;
            pre = head;
            head = t;
        }
        return  head;
    }

    /**
     *  重现实现
     *执行结果： 通过 显示详情 添加备注 执行用时： 0 ms ,
     * 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.2 MB , 在所有 Java 提交中击败了 48.87% 的用户
     * 通过测试用例： 28 / 28
     *把整个链条 分为三部分
     * 已反转|处理反转|待反转 三部分。
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head =next;
        }
        return pre;
    }
}

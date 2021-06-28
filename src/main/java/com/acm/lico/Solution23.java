package com.acm.lico;

import java.util.PriorityQueue;

/**
 * Solution23 class
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。

 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * @author 格林
 * @date 2021-06-27
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for(int i = 0; i < lists.length; i ++) {
            while (lists[i]!=null) {
                priorityQueue.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!priorityQueue.isEmpty()) {
            cur.next = new ListNode(priorityQueue.poll());
            cur = cur.next;
        }
        return head.next;
    }

    class Status implements Comparable<Status> {
        ListNode node;

        public Status( ListNode node) {
            this.node = node;
        }

        @Override
        public int compareTo(Status o) {
            return this.node.val - o.node.val;
        }
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<Status> priorityQueue = new PriorityQueue();
        for(int i = 0; i < lists.length; i ++) {
            if(lists[i] != null) {
                priorityQueue.offer(new Status(lists[i]));
            }
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (!priorityQueue.isEmpty()) {
            Status pollStatus = priorityQueue.poll();
            cur.next = pollStatus.node;
            cur = cur.next;
            if(pollStatus.node.next != null) {
                priorityQueue.offer(new Status(pollStatus.node.next));
            }
        }
        return head.next;
    }
}

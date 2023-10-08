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

    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N)
     空间复杂度  O(1)
     O(1) 一个常量下完成
     O(n) 一次遍历
     O(logn) 折半查询
     O(n^2) 两重嵌套循环查询
     2 定位问题
     根据问题类型，确定采用何种算法思维。
     例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
     思路：
     1. 双指针， 添加哨兵节点，解决边界情况， 前指针left 指向 head， right 走n步、
     2. 然后 lfet,right 一起走 直到 right.next == null。
     3. left = left.next
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:39.3 MB,击败了85.55% 的Java用户
     */
    public ListNode removeNthFromEndNew2(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode left = pre, right = pre ;
        while (n > 0) {
            right = right.next;
            n--;
        }
        while ((right != null) &&( right.next != null)) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return pre.next;

    }
}

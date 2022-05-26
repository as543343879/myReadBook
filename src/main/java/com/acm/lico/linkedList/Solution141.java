package com.acm.lico.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution141 class
 * https://leetcode.cn/problems/linked-list-cycle/
 * @author 谢小平
 * @date 2022/5/26
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class Solution141 {
    /**
     1 复杂度分析
    估算问题中复杂度的上限和下限
     时间复杂度
     空间复杂度
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
     3 数据操作分析
        根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     执行用时： 5 ms , 在所有 Java 提交中击败了 5.70% 的用户
     内存消耗： 41.9 MB , 在所有 Java 提交中击败了 94.18% 的用户
     通过测试用例： 21 / 21
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if(nodeSet.contains(head)) {
                return true;
            }
            nodeSet.add(head);
            head = head.next;

        }

        return false;
    }
}

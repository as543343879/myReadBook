package com.acm.lico.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution234 class
 * https://leetcode.cn/problems/palindrome-linked-list/
 *234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：false
 * @author 谢小平
 * @date 2022/7/11
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(N)
 空间复杂度
 O(N)
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
 */
//
//  class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
//
public class Solution234 {

    /**
     * new LinkedList<>()
     * 超出时间限制
     *
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 47.38% 的用户
     * 内存消耗： 53.1 MB , 在所有 Java 提交中击败了 86.90% 的用户
     * 通过测试用例： 86 / 86 炫耀一下:
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
//        ListNode first = head;
//        ListNode second = head;
        boolean res = true;
        ListNode currentNode = head;
        // new LinkedList<>()
        List<Integer> list = new ArrayList<>();
        while (currentNode != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if(! list.get(left).equals(list.get(right)) ) {
                return false;
            }
            left ++;
            right --;
        }
        return res;
    }
}

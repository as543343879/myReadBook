package com.acm.lico.linkedList; /**
 92 ,反转链表 II
 //给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
 //表节点，返回 反转后的链表 。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：head = [1,2,3,4,5], left = 2, right = 4
 //输出：[1,4,3,2,5]
 //
 //
 // 示例 2：
 //
 //
 //输入：head = [5], left = 1, right = 1
 //输出：[5]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 链表中节点数目为 n
 // 1 <= n <= 500
 // -500 <= Node.val <= 500
 // 1 <= left <= right <= n
 //
 //
 //
 //
 // 进阶： 你可以使用一趟扫描完成反转吗？
 //
 // Related Topics 链表 👍 1430 👎 0

 **/
/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 reverseBetween:
     时间复杂度
     O(N)
     空间复杂度
     O(1)
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询
 2 定位问题
 反转链表
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 reverseBetween:
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:39.2 MB,击败了52.02% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = null , rightNode, rightNodeNext = null;
        ListNode t = new ListNode(0);
        t.next = head;
        head = t;
        left --;
//        right++;
        int count = 0;
        while (t != null) {
            if(count == left) {
                leftNode = t;
            }
            if(count == right) {
                rightNode = t;
                rightNodeNext = rightNode.next;
                rightNode.next = null;
                break;
            }
            t = t.next;
            count++;
        }
        t = leftNode.next;
        ListNode reverseNode =  reverse(leftNode.next);
        if(t  != null) {
            t.next = rightNodeNext;
        }
        leftNode.next = reverseNode;
        return head.next;
    }

    /**
     * 反转字符串
     */
    public ListNode reverse(ListNode root) {
        ListNode pre = null;
        while (root != null) {
            ListNode t = pre;
            pre = root;
            root = root.next;
            pre.next = t;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

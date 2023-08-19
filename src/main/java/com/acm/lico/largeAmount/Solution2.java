package com.acm.lico.largeAmount;
/**
 2 ,两数相加
 //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 //
 // 请你将两个数相加，并以相同形式返回一个表示和的链表。
 //
 // 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：l1 = [2,4,3], l2 = [5,6,4]
 342
 465
 //输出：[7,0,8]
 //解释：342 + 465 = 807.
 //
 //
 // 示例 2：
 //
 //
 //输入：l1 = [0], l2 = [0]
 //输出：[0]
 //
 //
 // 示例 3：
 //
 //
 //输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 //输出：[8,9,9,9,0,0,0,1]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 每个链表中的节点数在范围 [1, 100] 内
 // 0 <= Node.val <= 9
 // 题目数据保证列表表示的数字不含前导零
 //
 //
 // Related Topics 递归 链表 数学 👍 9278 👎 0

 **/
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
 自己思路：
 时间优先： 先把链表反转。 然后直接加。
 空间优先： 放到两个栈里面，然后 取值相加。
 5 执行结果
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution2 {
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
     解答成功: 可优化的点 用现成的数据结构
     执行耗时:1 ms,击败了100.00% 的Java用户
     内存消耗:42.2 MB,击败了21.38% 的Java用户
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while ( l1 != null ||  l2 != null) {
            if(l1 == null) {
                int count = l2.val + pre;
                ListNode t = new ListNode(count % 10);
                temp.next = t;
                temp = temp.next;
                pre = count / 10;
                l2 = l2.next;
            }
            else if(l2 == null) {
                int count = l1.val + pre;
                ListNode t = new ListNode(count % 10);
                temp.next = t;
                temp = temp.next;
                pre = count / 10;
                l1 = l1.next;
            } else {
                int count = l1.val + l2.val + pre ;
                ListNode t = new ListNode(count % 10);
                temp.next = t;
                temp = temp.next;
                pre = count / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if(pre != 0) {
            temp.next = new ListNode(pre);
        }
        return head.next;

    }


    public ListNode reserve(ListNode root) {
        ListNode pre = null;
        while (root != null) {
            ListNode node = root.next;
            root.next = pre;
            pre = root;
            root = node;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

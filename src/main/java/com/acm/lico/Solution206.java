package com.acm.lico; /**
 206 ,反转链表
 //给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 //
 //
 //
 //
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：head = [1,2,3,4,5]
 //输出：[5,4,3,2,1]
 //
 //
 // 示例 2：
 //
 //
 //输入：head = [1,2]
 //输出：[2,1]
 //
 //
 // 示例 3：
 //
 //
 //输入：head = []
 //输出：[]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 链表中节点的数目范围是 [0, 5000]
 // -5000 <= Node.val <= 5000
 //
 //
 //
 //
 // 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 //
 // Related Topics 递归 链表 👍 3105 👎 0

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
 自己思路：
 时间复杂度 O(N)
 空间复杂度 O(1)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 相当于 三个 数 交互

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:41.1 MB,击败了73.44% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)


//
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

class Solution206 {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;

    }

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
    public ListNode reverseListOld(ListNode head) {
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
//leetcode submit region end(Prohibit modification and deletion)

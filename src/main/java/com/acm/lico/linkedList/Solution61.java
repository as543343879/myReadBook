package com.acm.lico.linkedList; /**
 * 旋转链表:61
 * 2023-02-20 23:29:22
 * //给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：head = [1,2,3,4,5], k = 2
 * //输出：[4,5,1,2,3]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：head = [0,1,2], k = 4
 * //输出：[2,0,1]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 链表中节点的数目在范围 [0, 500] 内
 * // -100 <= Node.val <= 100
 * // 0 <= k <= 2 * 10⁹
 * //
 * //
 * // Related Topics 链表 双指针 👍 890 👎 0
 * <p>
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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
 自己思路：
 快慢指针法

 指针环，不能直接模拟，要找到本质。
 计算出链表的 长度， 找出尾部节点
 尾部节点，指向头节点，
 然后在 n -  k % n 的位置断开 n 从1开始计数
 对k之前的，保持之前的顺序， k 之后的反转。放到前面
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功: rotateRight rotateRight3
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:40.9 MB,击败了56.36% 的Java用户
 */
class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

    public ListNode rotateRight3(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int count = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }

        if (k == count) {
            return head;
        }
        k = count - k % count;
        tail.next = head;
        ListNode node = head;
        while (--k > 0) {
            node = node.next;
        }

        head = node.next;
        node.next = null;
        return head;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        ListNode fastK = head;
        ListNode tail = head;
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        while (k > 0) {
            if (fastK.next != null) {
                fastK = fastK.next;
            } else {
                tail = fastK;
                fastK = head;
            }
            k--;
        }
        if (tail == head) {
            while (tail.next != null) {
                tail = tail.next;
            }
        }
        ListNode fastKNext = null;
//        if(fastK == head) {
//            return head;
//        }
        if (fastK.next == null) {
            fastKNext = head;
            head = head.next;
            fastKNext.next = null;
            tail.next = fastKNext;
            return head;
        } else {
            fastKNext = fastK.next;
            fastK.next = null;
            tail.next = head;
            return fastKNext;
        }
//         fastKNext = fastK.next== null ? head: fastK.next;
//        fastK.next = null;
//        tail.next = head;
//        ListNode pre = reserve(fastKNext);
//        fastKNext.next = head;

    }
//    public ListNode reserve(ListNode head) {
//        ListNode pre = null;
//        while (head != null) {
//            ListNode t = head.next;
//            head.next = pre;
//            pre = head;
//            head = t;
//        }
//        return pre;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

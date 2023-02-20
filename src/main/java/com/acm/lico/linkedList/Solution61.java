package com.acm.lico.linkedList; /**
 旋转链表:61
 2023-02-20 23:29:22
 //给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：head = [1,2,3,4,5], k = 2
 //输出：[4,5,1,2,3]
 //
 //
 // 示例 2：
 //
 //
 //输入：head = [0,1,2], k = 4
 //输出：[2,0,1]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 链表中节点的数目在范围 [0, 500] 内
 // -100 <= Node.val <= 100
 // 0 <= k <= 2 * 10⁹
 //
 //
 // Related Topics 链表 双指针 👍 890 👎 0

 **/

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
 对k之前的，保持之前的顺序， k 之后的反转。放到前面
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
class Solution61 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        System.out.println(new Solution61().rotateRight(node1, 2));
    }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode fastK = head;
        ListNode tail = head;
        if (k == 0 || head == null || head.next == null) { return head; }
        while (k > 0) {
            if(fastK.next != null) {
                fastK = fastK.next;
            } else {
                tail = fastK;
                fastK = head;
            }
            k--;
        }
        if(tail == head) {
            while ( tail.next != null) {
                tail = tail.next;
            }
        }

        ListNode fastKNext = null;
        if(fastK.next== null) {
            fastKNext = head;
            head = head.next;
            fastKNext = null;

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

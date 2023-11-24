package com.acm.lico.Solution148; /**
 148 ,排序链表
 //给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 //
 //
 //
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：head = [4,2,1,3]
 //输出：[1,2,3,4]
 //
 //
 // 示例 2：
 //
 //
 //输入：head = [-1,5,3,4,0]
 //输出：[-1,0,3,4,5]
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
 // 链表中节点的数目在范围 [0, 5 * 10⁴] 内
 // -10⁵ <= Node.val <= 10⁵
 //
 //
 //
 //
 // 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 //
 // Related Topics 链表 双指针 分治 排序 归并排序 👍 1971 👎 0

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
 自己思路： 错误
 时间复杂度 O(nlogn)
 空间复杂度 O(nlogn)

 自己思路：
 时间复杂度 O(nlogn)
 - 归并排序的时间复杂度分为两个部分：分治和合并。在分治的过程中，
 - 每次将链表分成两半，需要进行 logn 次操作。
 - 在合并的过程中，需要比较每个节点的值，因此需要进行 n 次操作。因此，总的时间复杂度是 O(nlogn)。

 空间复杂度 O(logn)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 O(n log n) 时间复杂度和常数级空间复杂度
 要么归并排序


 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:10 ms,击败了91.90% 的Java用户
 内存消耗:49.1 MB,击败了72.84% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution148 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next =listNode4;
        Solution148 solution148 = new Solution148();
        solution148.sortListNew20(listNode1);
        System.out.println();

    }

    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度   O(logN) 错误 O(NlogN)
     空间复杂度  O(logN)
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
     解答成功:
     执行耗时:10 ms,击败了91.30% 的Java用户
     内存消耗:54.8 MB,击败了36.99% 的Java用户
     */
    public ListNode sortListNew20(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;

        ListNode sortNodeLeft =  sortListNew20(head);
        ListNode sortNodeRight =  sortListNew20
                (fast);
        head = merge(sortNodeLeft, sortNodeRight);
        return head;
    }


    public ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (head1 != null || head2 != null) {
            if(head1 == null) {
                temp.next = head2;
                break;
            } else if(head2 == null) {
                temp.next = head1;
                break;
            } else {
                if(head1.val < head2.val) {
                    temp.next = head1;
                    head1 = head1.next;
                } else {
                    temp.next = head2;
                    head2 = head2.next;
                }
                temp = temp.next;
            }
        }

        return head.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middleNode = slow.next;
        slow.next = null;

        ListNode preNode = sortList(head);
        ListNode nextNode = sortList(middleNode);
        ListNode res = meger(preNode, nextNode);
        return res;
    }

    private ListNode meger(ListNode head1, ListNode head2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        while (head1 != null || head2!=null) {
            if(head1 == null) {
                head.next = head2;
                break;
            } else if(head2 == null) {
                head.next = head1;
                break;
            } else {
                if(head1.val < head2.val) {
                    head.next = head1;
                    head1 = head1.next;
                } else {
                    head.next = head2;
                    head2 = head2.next;
                }
                head = head.next;
            }
        }
        return res.next;
    }

    /**
     * 旧的答案
     * @param head
     * @return
     */
    public ListNode sortListOld(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;

        ListNode left =  sortList(head);
        ListNode right = sortList(temp);
        ListNode h = new ListNode(0);
        ListNode result = h;
        while (left != null && right != null) {
            if(left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return result.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

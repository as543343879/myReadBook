package com.acm.lico; /**
 23 ,合并K个升序链表
 //给你一个链表数组，每个链表都已经按升序排列。
 //
 // 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 //
 //
 //
 // 示例 1：
 //
 // 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 //输出：[1,1,2,3,4,4,5,6]
 //解释：链表数组如下：
 //[
 //  1->4->5,
 //  1->3->4,
 //  2->6
 //]
 //将它们合并到一个有序链表中得到。
 //1->1->2->3->4->4->5->6
 //
 //
 // 示例 2：
 //
 // 输入：lists = []
 //输出：[]
 //
 //
 // 示例 3：
 //
 // 输入：lists = [[]]
 //输出：[]
 //
 //
 //
 //
 // 提示：
 //
 //
 // k == lists.length
 // 0 <= k <= 10^4
 // 0 <= lists[i].length <= 500
 // -10^4 <= lists[i][j] <= 10^4
 // lists[i] 按 升序 排列
 // lists[i].length 的总和不超过 10^4
 //
 //
 // Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2370 👎 0

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

 自己思路：错误
 时间复杂度  N* MlogM
 空间复杂度  N

 自己思路：错误
 时间复杂度  ：假设每个链表的最长长度是 n。在第一次合并后，ans 的长度为 n；第二次合并后，ans 的长度为 2×n，第 i 次合并后，ans 的长度为 i×n。第 i 次合并的时间代价是 O(n+(i−1)×n)=O(i×n)，那么总的时间代价为 O(∑
 i=1
 k
 ​
 (i×n))=O(
 2
 (1+k)⋅k
 ​
 ×n)=O(k
 2
 n)，故渐进时间复杂度为 O(k^2 * n)
 空间复杂度  1

 官方思路：k 元素个数， n 链表长度
 时间复杂度 进时间复杂度为 O(kn×logk)。
 空间复杂度  O(N)

 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 循环对两个list进行合并。
 官方思路：
 利用小顶堆。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:102 ms,击败了16.80% 的Java用户
 内存消耗:43.7 MB,击败了14.36% 的Java用户

 官方思路：
 解答成功:
 执行耗时:5 ms,击败了39.42% 的Java用户
 内存消耗:43.1 MB,击败了82.99% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)

import com.acm.lico.ListNode;

import java.util.PriorityQueue;

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
class Solution23 {
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度 O(N^2logN) 错误 O(K^2 N) k 合并的代价， n 最大长度 为N
     O(1) < O(logn) < O(n) < O(nlogn) < O(n^2) < O(n^3) < O(2^n) < O(n!)
     O(1) 常数阶
     O(logn) 对数阶
     O(n) 线性阶
     O(nlogn) 线性对数阶
     O(n^2) 平方阶
     O(n^3) 立方阶
     O(2^n) 指数阶
     O(n!) 阶乘阶
     空间复杂度 O(1)
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
     1. 编写一个方法 合并两个链表。
     2. 循环处理n个链表
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:98 ms,击败了25.16% 的Java用户
     内存消耗:42.1 MB,击败了63.29% 的Java用户
     */
    public ListNode mergeKListsNew20(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }
        ListNode res = merge(lists[0], lists[1]);
        for(int i = 2; i < lists.length; i ++) {
            res = merge(res , lists[i]);
        }
        return res;
    }

    /**
     * 时间复杂 O(n^2)
     * @param node1
     * @param node2
     * @return
     */
    private ListNode merge(ListNode node1, ListNode node2 ) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (node1 != null || node2 != null) {
            if(node1 == null) {
                head.next = node2;
                break;
            } else if(node2 == null) {
                head.next = node1;
                break;
            } else {
                if(node1.val < node2.val) {
                    head.next = node1;
                    node1 = node1.next;
                } else {
                    head.next = node2;
                    node2 = node2.next;
                }
                head = head.next;
            }
        }

        return temp.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<Integer> minHeap =  new PriorityQueue();
        for(ListNode t: lists) {
            while (t != null) {
                minHeap.offer(t.val);
                t = t.next;
            }
        }
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (!minHeap.isEmpty()) {
            temp.next = new ListNode(minHeap.poll());
            temp = temp.next;
        }

        return res.next;
    }
    /**
     *     循环对两个list进行合并。
     * @param lists
     * @return
     */
    public ListNode mergeKLists5(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        ListNode one = lists[0];
        for(int i = 1; i < lists.length; i ++) {
            one = mergeTwo(one, lists[i]);
        }
        return one;
    }

    public ListNode mergeTwo(ListNode one, ListNode two) {
        if(one == null && two == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (one != null || two != null) {
            if(one == null) {
                head.next = two;
                break;
            } else if(two == null) {
                head.next = one;
                break;
            } else if(one.val > two.val) {
                head.next = two;
                two = two.next;
            } else {
                head.next = one;
                one = one.next;
            }
            head = head.next;

        }
        return res.next;
    }

    /**
     * 以前的刷题记录
     * @param lists
     * @return
     */
    public ListNode mergeKLists3(ListNode[] lists) {
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

    class Status implements Comparable<Solution23.Status> {
        ListNode node;

        public Status( ListNode node) {
            this.node = node;
        }

        @Override
        public int compareTo(Solution23.Status o) {
            return this.node.val - o.node.val;
        }
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<Solution23.Status> priorityQueue = new PriorityQueue();
        for(int i = 0; i < lists.length; i ++) {
            if(lists[i] != null) {
                priorityQueue.offer(new Solution23.Status(lists[i]));
            }
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (!priorityQueue.isEmpty()) {
            Solution23.Status pollStatus = priorityQueue.poll();
            cur.next = pollStatus.node;
            cur = cur.next;
            if(pollStatus.node.next != null) {
                priorityQueue.offer(new Solution23.Status(pollStatus.node.next));
            }
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

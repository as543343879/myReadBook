package com.acm.lico.linkedList; /**
 142 ,环形链表 II
 //给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 //
 // 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
 //链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 //
 // 不允许修改 链表。
 //
 //
 //
 //
 //
 //
 // 示例 1：
 //
 //
 //
 //
 //输入：head = [3,2,0,-4], pos = 1
 //输出：返回索引为 1 的链表节点
 //解释：链表中有一个环，其尾部连接到第二个节点。
 //
 //
 // 示例 2：
 //
 //
 //
 //
 //输入：head = [1,2], pos = 0
 //输出：返回索引为 0 的链表节点
 //解释：链表中有一个环，其尾部连接到第一个节点。
 //
 //
 // 示例 3：
 //
 //
 //
 //
 //输入：head = [1], pos = -1
 //输出：返回 null
 //解释：链表中没有环。
 //
 //
 //
 //
 // 提示：
 //
 //
 // 链表中节点的数目范围在范围 [0, 10⁴] 内
 // -10⁵ <= Node.val <= 10⁵
 // pos 的值为 -1 或者链表中的一个有效索引
 //
 //
 //
 //
 // 进阶：你是否可以使用 O(1) 空间解决此题？
 //
 // Related Topics 哈希表 链表 双指针 👍 2063 👎 0

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
 自己思路 + 官方：
 时间复杂度 O(n)
 空间复杂度 O(1)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路 + 官方：
 是是否能重合
 a = 起点到入环点的距离
 b = 相遇点距离
 c = 相遇点，到入换点距离
 fast = a + n(b + c ) b = a + b(n + 1) + nc
 slow = 2a + 2b
 fast = 2 slow
 a = c + (n - 1) (b+c)
 所以到了相遇点后，然后 起点 跟slow点相遇点就是 入口点。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。

 4 编码实现

 5 执行结果
 > 2023/04/10 10:22:57
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:41.5 MB,击败了88.68% 的Java用户

 */
//leetcode submit region begin(Prohibit modification and deletion)


import java.util.HashSet;
import java.util.Set;



//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}

public class Solution142 {
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度 O(N)
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
     1. f 是快指针的步速， s 是满指针的步速。 a 入口节点之前的长度， b 是循环圆缺 节点长度
     2. 第一次相遇的时候 f = 2s | f = s + nb  | 两个等式相减。  s = nb | f = 2nb 。
     3. 入口节点 k = a + nb 。 然后slow 第一次相遇的时候 已经走了 nb。 让他 继续走a步， f 也走a 步。 相遇的节点就是 循环入口节点。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:42.9 MB,击败了5.22% 的Java用户
     */
    public ListNode detectCycleNew20(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        do {
            if(fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null &&  fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                ListNode start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }
        return null;
    }

    /**
     *  5 执行结果
     *  执行结果： 通过 显示详情 添加备注 执行用时： 4 ms ,
     *  在所有 Java 提交中击败了 5.52% 的用户 内存消耗： 42 MB ,
     *  在所有 Java 提交中击败了 19.43% 的用户 通过测试用例： 16 / 16
     * @param head
     * @return
     */
    public ListNode detectCycleOld(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (!nodeSet.contains(head)) {
                nodeSet.add(head);
            } else {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

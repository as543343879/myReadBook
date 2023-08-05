package com.acm.lico.linkedList; /**
 * 141 ,环形链表
 * //给你一个链表的头节点 head ，判断链表中是否有环。
 * //
 * // 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
 * //链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * //
 * // 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //
 * //
 * //输入：head = [3,2,0,-4], pos = 1
 * //输出：true
 * //解释：链表中有一个环，其尾部连接到第二个节点。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //
 * //
 * //输入：head = [1,2], pos = 0
 * //输出：true
 * //解释：链表中有一个环，其尾部连接到第一个节点。
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //
 * //
 * //输入：head = [1], pos = -1
 * //输出：false
 * //解释：链表中没有环。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 链表中节点的数目范围是 [0, 10⁴]
 * // -10⁵ <= Node.val <= 10⁵
 * // pos 为 -1 或者链表中的一个 有效索引 。
 * //
 * //
 * //
 * //
 * // 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 * //
 * // Related Topics 哈希表 链表 双指针 👍 1801 👎 0
 * <p>
 * <p>
 * 1 复杂度分析
 * 估算问题中复杂度的上限和下限
 * 时间复杂度
 * 空间复杂度
 * O(1) 一个常量下完成
 * O(n) 一次遍历
 * O(logn) 折半查询
 * O(n^2) 两重嵌套循环查询
 * <p>
 * 自己思路：
 * 时间复杂度 O(N）
 * 空间复杂度 O(1)
 * <p>
 * 2 定位问题
 * 根据问题类型，确定采用何种算法思维。
 * 例如
 * 这个问题是什么类型（排序、查找、最优化）的问题；
 * 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 * 采用哪些数据结构或算法思维，能把这个问题解决。
 * 自己思路：
 * 快慢指针，快指针走两步。 慢指针走一步。 相遇了就是有环，没相遇就是没环。
 * <p>
 * 3 数据操作分析
 * 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 * 4 编码实现
 * 5 执行结果
 * 自己思路：
 * 解答成功:
 * 执行耗时:0 ms,击败了100.00% 的Java用户
 * 内存消耗:42.6 MB,击败了44.11% 的Java用户
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

 自己思路：
 时间复杂度 O(N）
 空间复杂度 O(1)

 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 快慢指针，快指针走两步。 慢指针走一步。 相遇了就是有环，没相遇就是没环。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:42.6 MB,击败了44.11% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)


import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        boolean res = false;
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return res;
    }

    /**
     *  执行用时： 5 ms , 在所有 Java 提交中击败了 5.70% 的用户
     *  内存消耗： 41.9 MB , 在所有 Java 提交中击败了 94.18% 的用户
     *  通过测试用例： 21 / 21
     * @param head
     * @return
     */
    public boolean hasCycleOld(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            }
            nodeSet.add(head);
            head = head.next;

        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

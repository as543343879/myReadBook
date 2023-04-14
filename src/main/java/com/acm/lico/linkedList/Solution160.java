package com.acm.lico.linkedList; /**
 160 ,相交链表
 //给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 //
 // 图示两个链表在节点 c1 开始相交：
 //
 //
 //
 // 题目数据 保证 整个链式结构中不存在环。
 //
 // 注意，函数返回结果后，链表必须 保持其原始结构 。
 //
 // 自定义评测：
 //
 // 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 //
 //
 // intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 // listA - 第一个链表
 // listB - 第二个链表
 // skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 // skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
 //
 //
 // 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视
 //作正确答案 。
 //
 //
 //
 // 示例 1：
 //
 //
 //
 //
 //输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2,
 //skipB = 3
 //输出：Intersected at '8'
 //解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 //从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 //在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 //— 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。换句话说，它们在内
 //存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
 //
 //
 //
 //
 // 示例 2：
 //
 //
 //
 //
 //输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
 //1
 //输出：Intersected at '2'
 //解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 //从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
 //在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 //
 //
 // 示例 3：
 //
 //
 //
 //
 //输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 //输出：null
 //解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 //由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 //这两个链表不相交，因此返回 null 。
 //
 //
 //
 //
 // 提示：
 //
 //
 // listA 中节点数目为 m
 // listB 中节点数目为 n
 // 1 <= m, n <= 3 * 10⁴
 // 1 <= Node.val <= 10⁵
 // 0 <= skipA <= m
 // 0 <= skipB <= n
 // 如果 listA 和 listB 没有交点，intersectVal 为 0
 // 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
 //
 //
 //
 //
 // 进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？
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

 自己思路：
 时间复杂度 O(N+M)
 空间复杂度 O(1)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 hash表, 一个链接表先用hash表存起来。颖一个再遍历 错误
 时间复杂度 O(N+M)
 空间复杂度 O(N)
 hash表， a走完，走b， b走完走a。 第一个相遇的就是 交点。

 不用hash表，走b， b走完走a。 第一个相遇的就是 交点。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路： hash表， a走完，走b， b走完走a。 第一个相遇的就是 交点。
 解答成功:
 执行耗时:7 ms,击败了9.46% 的Java用户
 内存消耗:44.4 MB,击败了45.87% 的Java用户

 自己思路 不用hash表
 解答成功:
 执行耗时:1 ms,击败了97.86% 的Java用户
 内存消耗:44.1 MB,击败了81.48% 的Java用户
 */

/**
 * 旧的
 *  1 复杂度分析
 * 估算问题中复杂度的上限和下限
 *  时间复杂度
 *  空间复杂度
 *     O(1) 一个常量下完成
 *     O(n) 一次遍历
 *     O(logn) 折半查询
 *     O(n^2) 两重嵌套循环查询
 *  2 定位问题
 * 根据问题类型，确定采用何种算法思维。
 *  双指针法。
 *  hash表法
 *  * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 *  * 假如 A 是 第三个节点
 *  * 接入 B 是 第四个节点
 *  *  t % 6 == 3 在交点
 *  *  t % 7 == 4 在交点 t == 39 的时候 满足运算。
 *     例如
 *      这个问题是什么类型（排序、查找、最优化）的问题；
 *      这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 *      采用哪些数据结构或算法思维，能把这个问题解决。
 *  3 数据操作分析
 *     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 *  4 编码实现
 *  5 执行结果
 *  执行结果： 通过 显示详情 添加备注
 *  执行用时： 316 ms , 在所有 Java 提交中击败了 5.75% 的用户
 *  内存消耗： 44.3 MB , 在所有 Java 提交中击败了 43.24% 的用户
 *  通过测试用例： 39 / 39
 */
//leetcode submit region begin(Prohibit modification and deletion)

import com.acm.lico.linkedList.ListNode;

import java.util.HashSet;
import java.util.Set;


// class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}

public class Solution160 {

    /**
     * old
     *  执行结果： 通过 显示详情 添加备注
     *  执行用时： 316 ms , 在所有 Java 提交中击败了 5.75% 的用户
     *  内存消耗： 44.3 MB , 在所有 Java 提交中击败了 43.24% 的用户
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeOld(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int count = 0;
        while (tempA != tempB) {
            count++;
            tempA = tempA == null ? headA : tempA.next;
            tempB = tempB == null ? headB : tempB.next;
        }
        System.out.println(count);
        return tempA;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        boolean aisNulled = false, bisNulled = false;
        ListNode tempA = headA, tempB = headB;
        while (headA != null && headB != null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
            if(headA == null && !aisNulled) {
                aisNulled = true;
                headA = tempB;
            }
            if(headB == null && ! bisNulled) {
                bisNulled = true;
                headB = tempA;
            }

        }

        return null;
    }

    /**
     *  5 执行结果
     *  自己思路： hash表， a走完，走b， b走完走a。 第一个相遇的就是 交点。
     *      解答成功:
     *      执行耗时:7 ms,击败了9.46% 的Java用户
     *      内存消耗:44.4 MB,击败了45.87% 的Java用户
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        boolean isFast = true;
        while (headA != null) {
            boolean addRes = set.add(headA);
            if(!addRes) {
                return headA;
            }
            headA = headA.next;
            if(headA == null && isFast) {
                isFast = false;
                headA = headB;
            }
        }
        return null;
    }
    /**
     * 没看清题目，思路错误
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<Integer> set = new HashSet<>();
        if(headA != null) {
            headA  = headA.next;
        }
        while (headA.next != null) {
            Integer val = headA.val;
            if(val!= 1) {
                set.add(val);
            }

            headA = headA.next;
        }


        ListNode res = null;
        while (headB != null) {
            Integer value = headB.val;
            if(set.contains(value)) {
                res = headB;
                break;
            }
            headB = headB.next;

        }


        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

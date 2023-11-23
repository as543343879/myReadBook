package com.acm.lico.linkedList;

import java.util.HashMap;
import java.util.Map;
/**
 随机链表的复制:138
 2023-11-23 09:11:04
 //给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 //
 // 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random
 //指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 //
 // 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random
 //--> y 。
 //
 // 返回复制链表的头节点。
 //
 // 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 //
 //
 // val：一个表示 Node.val 的整数。
 // random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。
 //
 //
 // 你的代码 只 接受原链表的头节点 head 作为传入参数。
 //
 //
 //
 // 示例 1：
 //
 //
 //
 //
 //输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 //输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 //
 //
 // 示例 2：
 //
 //
 //
 //
 //输入：head = [[1,1],[2,1]]
 //输出：[[1,1],[2,1]]
 //
 //
 // 示例 3：
 //
 //
 //
 //
 //输入：head = [[3,null],[3,0],[3,null]]
 //输出：[[3,null],[3,0],[3,null]]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 0 <= n <= 1000
 //
 // -10⁴ <= Node.val <= 10⁴
 // Node.random 为 null 或指向链表中的节点。
 //
 //
 //
 //
 // Related Topics 哈希表 链表 👍 1267 👎 0

 **/

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.

*/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution138 {
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度 O(N)
     空间复杂度 O(N)
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
     1. 利用hash 存 key是值， value 是node 的节点。
     2. 然后便利。 指定 next random。 random 先放入map。 然后next 可以从map里面取。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     错误一次： val 可能会 重复。
     5 执行结果
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:41.8 MB,击败了88.66% 的Java用户
     */
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node t = head;
        Node newHead = new Node(0);
        Node newHeadTemp = newHead;
        while (t != null) {
            Node node = map.get(t);
            if(node == null) {
                node = new Node(t.val);
                map.put(t, node);
            }
            if(t.random != null) {
                Node random = map.get(t.random);
                if(random == null) {
                    random = new Node(t.random.val);
                    map.put(t.random, random);
                }
                node.random = random;

            }
            newHeadTemp.next = node;
            newHeadTemp = newHeadTemp.next;
            t = t.next;
        }
        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

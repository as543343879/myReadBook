package com.acm.lico.tree; /**
 合并二叉树:617
 2022-12-20 15:19:48
 //给你两棵二叉树： root1 和 root2 。
 //
 // 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠
 //，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 //
 // 返回合并后的二叉树。
 //
 // 注意: 合并过程必须从两个树的根节点开始。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 //输出：[3,4,5,5,4,null,7]
 //
 //
 // 示例 2：
 //
 //
 //输入：root1 = [1], root2 = [1,2]
 //输出：[2,2]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 两棵树中的节点数目在范围 [0, 2000] 内
 // -10⁴ <= Node.val <= 10⁴
 //
 //
 // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1128 👎 0

 **/

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import com.acm.lico.offer68.TreeNode;

import java.util.LinkedList;

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
 先序遍历，遍历节点新新建一个node，node 做等于 两边的左节点， node 的右 等于两边的右节点。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:41.5 MB,击败了53.21% 的Java用户
 */
class Solution617 {
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if(root1 == null) {
            return root2;
        }
        if(root2 == null) {
            return root1;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }

    /**
     * 改成循环
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = new TreeNode(0);
        TreeNode head = root;
        LinkedList<TreeNode> resList = new LinkedList<TreeNode>();
        LinkedList<TreeNode> rootList1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> rootList2 = new LinkedList<TreeNode>();
        resList.push(root);
        while ( ( root1 != null || root2 != null) || (!rootList1.isEmpty() || ! rootList2.isEmpty())) {
            while (root1 != null || root2 != null)  {
                root = new TreeNode((root1 == null ? 0 :root1.val) + (root2 == null ? 0: root2.val));
                rootList1.push(root1);
                rootList1.push(root2);

                resList.peek().left = root;
                resList.push(root);

                root1 = root1 == null ? null : root1.left;
                root2 = root2 == null ? null : root2.left;
            }

            root1 = rootList1.pop();
            root2 = rootList2.pop();
            root = resList.pop();

            root1 = root1 == null ? null : root1.right;
            root2 = root2 == null ? null : root2.right;

            if(root1 != null || root1 != null) {
                root = new TreeNode((root1 == null ? 0 :root1.val) + (root2 == null ? 0: root2.val));
                rootList1.push(root1);
                rootList1.push(root2);
                resList.peek().right = root;
                resList.push(root);

                root1 = root1 == null ? null : root1.left;
                root2 = root2 == null ? null : root2.left;

            }

        }
        return head.left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

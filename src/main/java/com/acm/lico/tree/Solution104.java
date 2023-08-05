package com.acm.lico.tree; /**
 104 ,二叉树的最大深度
 //给定一个二叉树，找出其最大深度。
 //
 // 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 //
 // 说明: 叶子节点是指没有子节点的节点。
 //
 // 示例： 给定二叉树 [3,9,20,null,null,15,7]，
 //
 //     3
 //   / \
 //  9  20
 //    /  \
 //   15   7
 //
 // 返回它的最大深度 3 。
 //
 // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1557 👎 0

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
 时间复杂度  O(N)
 空间复杂度  O(logN)

 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 dfs 深度搜索， 往下遍历的时候， 有孩子就深度加1。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:41.4 MB,击败了20.08% 的Java用户
 */

import com.acm.lico.offer68.TreeNode;

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
class Solution104 {
    public int maxDepth(TreeNode root) {
        return dfs(root,0);
    }

    public int dfs(TreeNode root, int depth) {
        if(root == null) {
            return depth;
        }
        int leftDepth = dfs(root.left, depth + 1);
        int rightDepth = dfs(root.right, depth + 1);
        return Math.max(leftDepth,rightDepth);
    }

    /**
     * old ac
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1  + Math.max(maxDepth(root.left),maxDepth(root.right)) ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package com.acm.lico.tree; /**
 124 ,二叉树中的最大路径和
 //路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
 //一定经过根节点。
 //
 // 路径和 是路径中各节点值的总和。
 //
 // 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：root = [1,2,3]
 //输出：6
 //解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 //
 // 示例 2：
 //
 //
 //输入：root = [-10,9,20,null,null,15,7]
 //输出：42
 //解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 //
 //
 //
 //
 // 提示：
 //
 //
 // 树中节点数目范围是 [1, 3 * 10⁴]
 // -1000 <= Node.val <= 1000
 //
 //
 // Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1906 👎 0

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

 参考官网后的思路：
 时间复杂度 O(N) n 表示节点个数
 空间复杂度 O(logN) 栈的复杂度

 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。

 参考官网后的思路：
 答案一定是选择了某个根节点
 假如选择了某个根节点
 max = (root.val + left.val, root.val + right.val, root.val + left.val + right.val)

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果

 参考官方后的思路：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:43 MB,击败了43.30% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)

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
class Solution124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftSum = Math.max(0, dfs(root.left)) ;
        int rightSum = Math.max(0, dfs(root.right));
        int tempMax = Math.max(leftSum + root.val, rightSum + root.val);
        int returnMax = tempMax;
        tempMax = Math.max(tempMax, leftSum + rightSum + root.val);
        max = Math.max(tempMax, max);
        return returnMax;
    }


    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度
     O(n)
     空间复杂度
     O(n) 一次遍历
     2 定位问题
     根据问题类型，确定采用何种算法思维。
     递归，后续遍历二叉树
     3 数据操作分析
     无
     4 编码实现
     5 执行结果
     执行结果： 通过 显示详情 添加备注
     执行用时： 1 ms , 在所有 Java 提交中击败了 27.72% 的用户
     内存消耗： 42.9 MB , 在所有 Java 提交中击败了 39.65% 的用户
     通过测试用例： 94 / 94
     */
    /**
     * 旧的答案
     * @param root
     * @return
     */
    public int maxPathSum2(TreeNode root) {
        dfs2(root);
        return max;
    }

    public int dfs2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);
//        int leftMax = dfs(root.left);
//        int rightMax = dfs(root.right);
        int tMax = Math.max(leftMax + root.val,rightMax + root.val);
        int iMax = Math.max(leftMax + root.val+ rightMax, tMax);
        max = Math.max(iMax , max);
        return tMax;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

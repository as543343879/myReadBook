package com.acm.lico.tree;

import com.acm.lico.offer68.TreeNode;

/**
 * Solution124 class
 * 124. 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * @author 谢小平
 * @date 2021/9/24
 */
public class Solution124 {

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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
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

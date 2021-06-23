package com.acm.lico;

/**
 * Solution112 class
 * 12. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-20
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean flag = false;
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }
        return hasPathSum(root.right,targetSum - root.val) ||  hasPathSum(root.left,targetSum - root.val);
    }
}

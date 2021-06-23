package com.acm.lico;

/**
 * Solution437 class
 * 437. 路径总和 III
 *  给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-20
 */
public class Solution437 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        return pathSum(root.left,targetSum) + pathSum(root.right,targetSum) + countSum(root,targetSum);
    }

    private int countSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        targetSum -= root.val;
        int res = targetSum == 0 ? 1 : 0;
        return countSum(root.left,targetSum) + countSum(root.right ,targetSum) + res;

    }
}

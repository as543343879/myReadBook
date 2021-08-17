package com.acm.lico.tree;

import com.acm.lico.offer68.TreeNode;

/**
 * Solution101 class
 * 给定一个二叉树，检查它是否是镜像对称的。

 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 谢小平
 * @date 2021/8/11
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
    O(n) 一次遍历
 2 定位问题
根据问题类型，确定采用何种算法思维。
    递归
 3 数据操作分析
    不用特殊数据结构
 4 编码实现
 */

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if(left == null || right == null) {
            return false;
        }

        return left.val == right.val && check(left.left,right.right) && check(left.right, right.left);

    }




}

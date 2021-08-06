package com.acm.lico;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution94 class
 *94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *  1 复杂度分析 O（n)
 *  2 定位问题 二叉树的 中序 递归
 *  3 数据操作分析
 *
 * @author 谢小平
 * @date 2021/8/6
 */
public class Solution94 {
    List<Integer> result = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        middleOrder(root);
        return result;
    }

    private void middleOrder(TreeNode root) {
        if(root == null)
            return ;
        if(root.left != null)
            middleOrder(root.left);

        result.add(root.val);

        if(root.right != null)
            middleOrder(root.right);
    }

}

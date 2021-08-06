package com.acm.lico;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution94 class
 *94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *  1 复杂度分析 O（n)
 *  2 定位问题 二叉树的 中序 迭代
 *  3 数据操作分析
 *
 * @author 谢小平
 * @date 2021/8/6
 */
public class Solution94V2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode popNode = stack.pop();
            result.add(popNode.val);

            root = popNode.right;
        }
        return result;
    }



}

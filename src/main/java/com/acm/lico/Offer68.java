package com.acm.lico;

import com.acm.lico.offer68.TreeNode;

/**
 * Offer68 class
 *
 * @author 谢小平
 * @date 2020-07-31
 */
public class Offer68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归到叶子节点，或者 找到pq 直接回溯pq
        if(root == null || p.val == root.val || q.val == root.val) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rigthNode = lowestCommonAncestor(root.right, p, q);


        if(leftNode == null && rigthNode == null){
            return null;
        }

        if(leftNode == null) {
            return rigthNode;
        }
        if(rigthNode == null) {
            return leftNode;
        }
        //异侧，就回溯 pq 的父节点
        return root;
    }
}

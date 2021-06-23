package com.acm.lico;

/**
 * Solution543 class
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * @author 格林
 * @date 2020-12-17
 */
public class Solution543 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private  int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        deph(root);
        return max;

    }

    private int deph(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftMax = deph(root.left) ;
        int rightMax = deph(root.right) ;
        max = Math.max( leftMax + rightMax , max);
        return Math.max(leftMax,rightMax) + 1;
    }


}



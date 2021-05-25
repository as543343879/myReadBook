package com.acm.lico;

/**
 * Solution543 class
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



package com.acm.lico.Solution687;

/**
 * 687. 最长同值路径
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public  class Solution {
    private int res;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        longPath(root);
        return res;
    }

    private int longPath(TreeNode root) {
        if(root == null)
            return 0;
        int left = longPath(root.left);
        int right = longPath(root.right);
        if(root.left != null && root.left.val == root.val)
            left ++;
        else
            left = 0;

        if(root.right != null && root.right.val == root.val)
            right ++;
        else
            right = 0;
        res = Math.max(res,left + right);
        return Math.max(right,left);
    }
}
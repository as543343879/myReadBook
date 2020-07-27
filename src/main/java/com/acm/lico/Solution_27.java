package com.acm.lico;

/**
 * Solution_27 class
 * 二叉树的镜像
 * @author 谢小平
 * @date 2020-07-13
 */
public class Solution_27 {
	  public class TreeNode {
	      int val;
	     TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	class Solution {
		public TreeNode mirrorTree(TreeNode root) {
			if(root == null) {
				return null;
			}
			TreeNode t = root.left;
			root.left = mirrorTree(root.right);
			root.right = mirrorTree(t);
			return root;
		}

	}
}



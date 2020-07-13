package com.acm.lico;

/**
 * Solution98 class
 * 错误 只是局部判断
 * @author 谢小平
 * @date 2020-07-10
 */
public class Solution98 {

// Definition for a binary tree node.
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	class Solution {
		public boolean isValidBST(TreeNode root) {
			if(root == null) {
				return true;
			}
			TreeNode left =  root.left;
			TreeNode right = root.right;
			if(!compare(root,right,left)){
				return false;
			}
			boolean value = isValidBST(left);
			if(!value) {
				return value;
			}
			value = isValidBST(right);
			if(!value) {
				return value;
			}
			return true;
		}

		/**
		 * 看是否符合规范
		 * @param root
		 * @param right
		 * @param left
		 * @return
		 */
		boolean compare(TreeNode root ,TreeNode right,TreeNode left ) {

			if(right != null) {
				if(right.val <= root.val) {
					return false;
				}
			}
			if(left != null) {
				if(left.val >= root.val) {
					return false;
				}
			}
			return true;
		}



	}
}

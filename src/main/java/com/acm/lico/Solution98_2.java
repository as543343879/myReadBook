package com.acm.lico;

/**
 * Solution98_2 class
 * 中序遍历 当前 大于 前一个结点
 * @author 谢小平
 * @date 2020-07-10
 */
public class Solution98_2 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	class Solution {
		long pre = Long.MIN_VALUE;
		public boolean isValidBST(TreeNode root) {
			if(root == null) {
				return true;
			}
			if(!isValidBST(root.left)){
				return false;
			}
			if(root.val <= pre) {
				return false;
			}
			pre = root.val;
			return isValidBST(root.right);
		}
	}
}

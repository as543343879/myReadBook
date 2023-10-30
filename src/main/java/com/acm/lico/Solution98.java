package com.acm.lico;

import javafx.util.Pair;

import java.util.Stack;

/**
 * Solution98 class
 * 错误 只是局部判断
 * @author 谢小平
 * @date 2020-07-10
 */
public class Solution98 {
	/**
	 1 复杂度分析
	 估算问题中复杂度的上限和下限
	 时间复杂度 O(N)
	 空间复杂度  O(N)
	 O(1) 一个常量下完成
	 O(n) 一次遍历
	 O(logn) 折半查询
	 O(n^2) 两重嵌套循环查询
	 2 定位问题
	 根据问题类型，确定采用何种算法思维。
	 例如
	 这个问题是什么类型（排序、查找、最优化）的问题；
	 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
	 采用哪些数据结构或算法思维，能把这个问题解决。
	 思路：
	 通过 中序便利， 判断 当前节点是否小于前一个节点。
	 3 数据操作分析
	 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
	 4 编码实现
	 5 执行结果
	 解答成功:
	 执行耗时:11 ms,击败了2.68% 的Java用户
	 内存消耗:42.8 MB,击败了22.98% 的Java用户
	 */
	public boolean isValidBSTNew20(TreeNode root) {
		if(root == null) {
			return  true;
		}
		Stack<Pair<TreeNode,Boolean>> stack = new Stack<>();
		stack.push(new Pair<TreeNode, Boolean>(root, false));
		Long preMax = Long.MIN_VALUE;
		while (!stack.isEmpty()) {
			Pair<TreeNode, Boolean> pop = stack.pop();
			if (pop.getKey() == null) {
				continue;
			}
			if(pop.getValue()) {
				if(preMax >= pop.getKey().val) {
					return false;
				}
				preMax = (long)pop.getKey().val;
			} else {
				stack.push(new Pair<TreeNode, Boolean>(pop.getKey().right, false));
				stack.push(new Pair<TreeNode, Boolean>(pop.getKey(), true));
				stack.push(new Pair<TreeNode, Boolean>(pop.getKey().left, false));
			}
		}

		return true;
	}
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

package com.acm.lico.tree;

/**
 * Solution108 class
 *108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * @author 谢小平
 * @date 2021/9/4
 */

import com.acm.lico.offer68.TreeNode;

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
    O(n) 一次遍历
 空间复杂度
    O(n) 一次遍历
 2 定位问题
根据问题类型，确定采用何种算法思维。
    例如
        递归 贪心策略构建平衡二叉树
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        return buildBST(nums,0,nums.length -1);
    }

    private TreeNode buildBST(int[] nums,int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = (right + left) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = buildBST(nums,left,mid - 1);
        treeNode.right = buildBST(nums,mid + 1, right);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode treeNode = new Solution108().sortedArrayToBST(nums);
        System.out.println(treeNode);
    }
}

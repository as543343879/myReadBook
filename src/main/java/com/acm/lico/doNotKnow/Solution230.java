package com.acm.lico.doNotKnow;

/**
 * Solution230 class
 *230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * @author 谢小平
 * @date 2022/7/11
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(N)
 空间复杂度
 O(1)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。
 树的中序遍历
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 55.28% 的用户
 通过测试用例： 93 / 93
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
public class Solution230 {
    private int count = 0;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }

    public void dfs (TreeNode root, int k ) {
        if(root == null) {
            return;
        }
        if(count >= k) {
            return;
        }
        dfs(root.left,k);
        count++;
        if(count == k) {
            res = root.val;
        }
        dfs(root.right,k);

    }
}

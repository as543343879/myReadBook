package com.acm.lico.tree;
//199 二叉树的右视图
//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 781 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 rightSideView:
 时间复杂度 O(N)
 空间复杂度 O(N)


    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
 深度搜索 右边的节点
根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 rightSideView:
     解答成功:
     执行耗时:1 ms,击败了81.60% 的Java用户
     内存消耗:39.8 MB,击败了94.53% 的Java用户
 */
class Solution199 {
    Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
    int maxDepth = 0;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        dfs(root,0);
        List<Integer> resList = new ArrayList<>(rightmostValueAtDepth.size());
        for(int i = 0 ; i <= maxDepth; i ++) {
            resList.add(rightmostValueAtDepth.get(i));
        }
        return resList;
    }
    public void dfs(TreeNode root,int depth) {
        if(root == null) {
            return ;
        }
        maxDepth = Math.max(depth, maxDepth);
        if(!rightmostValueAtDepth.containsKey(depth)) {
            rightmostValueAtDepth.put(depth, root.val);
        }
        depth ++;
        dfs(root.right, depth );
        dfs(root.left, depth);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

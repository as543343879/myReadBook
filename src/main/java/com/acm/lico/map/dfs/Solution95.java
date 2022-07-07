package com.acm.lico.map.dfs;

import com.acm.lico.offer68.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution95 class
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * @author 谢小平
 * @date 2021/12/3
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 卡特兰数
 空间复杂度
 卡特兰数

 2 定位问题
根据问题类型，确定采用何种算法思维。
 - 类型 树，回溯。

     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> treeNodeList = new LinkedList<>();
        if(left > right) {
            treeNodeList.add(null);
            return treeNodeList;
        }
        for(int i = left; i <= right; i ++) {

            List<TreeNode> leftNodeList = dfs(left, i - 1);
            List<TreeNode> rightNodeList = dfs(i + 1, right);

            for(TreeNode leftNode: leftNodeList) {
                for(TreeNode rightNode : rightNodeList) {
                    TreeNode root = new TreeNode(i);
                    treeNodeList.add(root);
                    root.left = leftNode;
                    root.right = rightNode;
                }
            }

        }
        return treeNodeList;
    }


}

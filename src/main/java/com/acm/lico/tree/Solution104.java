package com.acm.lico.tree;

import com.acm.lico.offer68.TreeNode;

/**
 * Solution104 class
 *给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 谢小平
 * @date 2021/8/23
 */

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
    O(n) 一次遍历
 空间复杂度
    O(高度)

 2 定位问题
根据问题类型，确定采用何种算法思维。
    二叉树层次遍历

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1  + Math.max(maxDepth(root.left),maxDepth(root.right)) ;
    }
}

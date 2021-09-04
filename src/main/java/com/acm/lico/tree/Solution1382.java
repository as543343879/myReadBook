package com.acm.lico.tree;

import com.acm.lico.offer68.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution1382 class
 *1382. 将二叉搜索树变平衡
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 *
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *
 * 如果有多种构造方法，请你返回任意一种。
 *
 * @author 谢小平
 * @date 2021/9/4
 */

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
    O(n) 一次遍历
 空间复杂度
    O(n) 一次遍历
 2 定位问题
根据问题类型，确定采用何种算法思维。
    树 二叉树 中序遍历， 贪心，递归

 3 数据操作分析
     遍历
 4 编码实现
 */
public class Solution1382 {
    List<TreeNode> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        buildOrder(root);
       return  buildBalancedTree(0,list.size() - 1);

    }

    private TreeNode buildBalancedTree(int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = (right + left) / 2;
        TreeNode treeNode = list.get(mid);

        treeNode.left = buildBalancedTree(left,mid - 1);
        treeNode.right = buildBalancedTree(mid + 1, right);

        return treeNode;

    }

    private void buildOrder(TreeNode root) {
        if(root == null) {
            return ;
        }
        buildOrder(root.left);
        list.add(root);
        buildOrder(root.right);
    }

}

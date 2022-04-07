package com.acm.lico.tree;

import com.acm.lico.offer68.TreeNode;

/**
 * Solution4 class
 *https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * @author 格林
 * @date 2022-01-28
 */

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
     O(n) 一次遍历
 空间复杂度
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
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
public class Solution114_2 {
    public void flatten(TreeNode root) {
        TreeNode head = new TreeNode(1);
        toLinkList(root,head);

    }


    private TreeNode toLinkList(TreeNode root, TreeNode father) {
        if(root == null ) {
            return null;
        }
        if(root.left == null && root.right == null) {
            return root;
        }
        father.right = root;

        System.out.println(root.val + ": father: " + father.val);

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        root.left = null;
        root.right = leftNode;
        TreeNode leftRes = null;
        if(leftNode != null) {
             leftRes =  toLinkList(leftNode, root);
        }
        if(rightNode != null) {
            TreeNode rightRes =  toLinkList(rightNode, leftNode == null ?  root : leftRes );
            if(rightRes != null) {
                return rightNode;
            }
        }
        return   root.right != null ? root.right : root;

    }
}

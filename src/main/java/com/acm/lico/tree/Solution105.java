package com.acm.lico.tree;

/**
 * Solution105 class
 *105. 从前序与中序遍历序列构造二叉树
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 * @author 谢小平
 * @date 2021/8/26
 */

import com.acm.lico.offer68.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
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
 */
public class Solution105 {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) {
            return null;
        }

        for(int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i],i);
        }

       return  buildTree(preorder,0,preorder.length - 1,inorder, 0 ,preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preorderLeft, int preorderRight, int[] inorder, int inorderLeft, int inorderRight) {
        if(preorderLeft > preorderRight) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preorderLeft] );
        int rootIndex =  map.get(treeNode.val);
        int lefSize = rootIndex - inorderLeft;

        treeNode.left = buildTree(preorder,preorderLeft + 1 ,preorderLeft + lefSize,inorder,inorderLeft,rootIndex  - 1  );
        treeNode.right = buildTree(preorder,preorderLeft + lefSize + 1 ,preorderRight,inorder,rootIndex + 1, inorderRight );

        return treeNode;
    }

    public static void main(String[] args) {
        int[] preorder =  {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(new Solution105().buildTree(preorder,inorder));
    }

}

package com.acm.lico;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Solution94 class
 *94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *  1 复杂度分析 O（n)
 *  2 定位问题 二叉树的 中序 递归
 *  3 数据操作分析
 *
 * @author 谢小平
 * @date 2021/8/6
 */
public class Solution94 {
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度 O(N)
     空间复杂度 O(logN)
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
     思路： 递归 中序便利

     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:39.7 MB,击败了23.57% 的Java用户
     */

    public List<Integer> inorderTraversalNew20(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);


    }

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
     思路： 对节点染色。 白色节点表示 没有访问过， 灰色节点表示 访问过。
     1. 如果是白色节点， 对右节点， 根节点， 左节点进栈。
     2. 如果是黑色 节点， 就直接 打印。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:1 ms,击败了7.51% 的Java用户
     内存消耗:39.5 MB,击败了71.41% 的Java用户
     */
    public List<Integer> inorderTraversalNew21(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<Pair> stack = new Stack<Pair>();
        stack.push( new Pair<TreeNode, Boolean>(root, false));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> peekNode = stack.pop();
            if(peekNode.getKey() == null) {
                continue;
            }
            else if(peekNode.getValue() ) {
                res.add(peekNode.getKey().val);
            } else {
                stack.push(new Pair<TreeNode, Boolean>(peekNode.getKey().right, false));
                stack.push(new Pair<TreeNode, Boolean>(peekNode.getKey(), true));
                stack.push(new Pair<TreeNode, Boolean>(peekNode.getKey().left, false));
            }
        }

        return res;
    }


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
     思路： 队列
     1. 对跟节点左子树入栈
     2. 获取子数
     3. 对右边子树入栈
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:

     */
    public List<Integer> inorderTraversalNew22(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root= stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    List<Integer> result = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        middleOrder(root);
        return result;
    }

    private void middleOrder(TreeNode root) {
        if(root == null)
            return ;
        if(root.left != null)
            middleOrder(root.left);

        result.add(root.val);

        if(root.right != null)
            middleOrder(root.right);
    }

}

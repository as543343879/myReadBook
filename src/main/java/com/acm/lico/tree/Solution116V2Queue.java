package com.acm.lico.tree;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Solution116 class
 *116. 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * @author 谢小平
 * @date 2021/9/3
 */

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
    0(n）
 空间复杂度
    O(n) 一次遍历
 2 定位问题
根据问题类型，确定采用何种算法思维。
    例如
        利用队列层次遍历
 3 数据操作分析
    队列。
 4 编码实现
 */



public class Solution116V2Queue {

    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        LinkedList<Node> queueNode = new LinkedList();
        queueNode.offer(root);
        while (!queueNode.isEmpty()) {

            Node temp = queueNode.peek();

            for(int i = 1; i < queueNode.size(); i ++) {
                Node node = queueNode.get(i);
                temp.next =  node;
                temp = node;
            }

            int n = queueNode.size();
            for(int i = 0; i < n; i ++) {
                Node node = queueNode.poll();
                if(node.left != null) {
                    queueNode.offer(node.left);
                }

                if(node.right != null) {
                    queueNode.offer(node.right);
                }

            }
        }

        return root;
    }


}

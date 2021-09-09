package com.acm.lico.tree;


import java.util.*;

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
 空间复杂度
    O(n) 一次遍历
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
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

// TODO: 2021/9/9 队列实现 
// TODO: 2021/9/9 不需要借助map

public class Solution116 {
    Map<Integer,Node> map = new HashMap<>();

    public Node connect(Node root) {
        buildNode(root, 0);
        return root;
    }

    private void buildNode(Node root, int level) {
        if(root == null) {
            return ;
        }
        Node iNode = map.get(level);
        if(iNode != null) {
            iNode.next = root;
        }
        map.put(level,root);
        buildNode(root.left,level + 1);

        buildNode(root.right,level + 1);
    }

    public static void main(String[] args) {
    }
}

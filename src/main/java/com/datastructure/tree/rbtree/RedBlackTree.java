package com.datastructure.tree.rbtree;

/**
 * RedBlackTree class
 *
 * @author 格林
 * @date 2020/3/31
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    public static final boolean RED = true;
    public static final boolean BLACK =false;

    private class Node{
        boolean color;
        Key key;
        Value value;
        /**
         * 这颗树的结点总数
         */
        int N;
        Node left, right;

        public Node(boolean color, Key key, Value value, int n) {
            this.color = color;
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    public boolean isRed(Node node) {
        if(node == null) return false;
        return node.color == RED;
    }
    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    Node rotateLeft(Node node) {
        Node t = node.right;
        node.right = node.right.left;
        t.left = node;
        t.right = node.right.right;
        return t;
    }

}

package com.datastructure.tree.rbtree;

import com.datastructure.tree.BinarySearchTree;

/**
 * RedBlackTree class
 *
 * @author 格林
 * @date 2020/3/31
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    public static final boolean RED = true;
    public static final boolean BLACK =false;

    private  Node root;

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
    public void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2

    /**
     * 什么时候左旋 就是node节点是红的。
     * 通过左旋node变成左节点，符合红黑树定义
     * @param node
     * @return
     */
    Node rotateLeft(Node node) {
        Node t = node.right;
        node.right = t.left;
        t.left = node;
        t.color = node.color;
        node.color = RED;
        t.N = node.N;
        node.N = 1  + node.left.N + node.right.N;
        return t;
    }

    /**
     *
     * @param node
     */
    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2

    /**
     * 右旋 就是因为左边有两个连续的红节点
     * 通过右旋使得左边红节点x 红色传到右边
     * @param node
     */
    public Node rotaeRight(Node node) {
        Node t = node.left;
        node.left = t.right;
        t.right = node;
        t.color = node.color;
        node.color = RED;
        t.N = node.N;
        node.N = 1 + node.left.N + node.right.N;
        return t;
    }

    public int size() {
        return size(root);
    }
    public int size(Node node) {
        if(node == null) return 0;
        else return node.N;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    public Node put(Node node, Key key, Value value) {
        if(node == null)
            return new Node(RED,key,value,1);
        int cmp = key.compareTo(node.key);
        if(cmp < 0)
            node.left = put(node.left,key,value);
        else if(cmp > 0)
            node.right = put(node.right,key,value);
        else
            node.value = value;

        if(isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if(isRed(node.left) && isRed(node.left.left)) node = rotaeRight(node);
        if(isRed(node.left) && isRed(node.right)) flipColors(node);

        node.N = size(node.left) + 1 + size(node.right);
        return node;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return inTraverse(root,stringBuilder);
    }

    /**
     * 中序遍历
     * @param node
     * @param stringBuilder
     * @return
     */
    public String inTraverse(Node node, StringBuilder stringBuilder ){
        if(node == null ) {
            return null;
        }
        inTraverse(node.left,stringBuilder);
        stringBuilder.append(" " + node.key + " : " + node.value);
        inTraverse(node.right,stringBuilder);
        return stringBuilder.toString();

    }

}

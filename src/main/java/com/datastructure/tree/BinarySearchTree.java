package com.datastructure.tree;

import javax.xml.soap.Node;

/**
 * BinaryTree class
 *
 * @author 谢小平
 * @date 2020/3/25
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private Node root;
    private int size;
    public E search(E e) {
        if(e == null || root == null) {
            return null;
        }
        if(e.compareTo(root.e))

    }
    private class Node {
        E e;
        Node lefeNode,rightNode;
        public void add(){

        }
        public Node(E e) {
            this.e = e;
            lefeNode = null;
            rightNode = null;
        }
    }
}

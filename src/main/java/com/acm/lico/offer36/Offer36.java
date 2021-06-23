package com.acm.lico.offer36;

/**
 * Offer36 class
 *
 * @author 格林
 * @date 2021-06-22
 */
public class Offer36 {
    private Node tail, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        traceTree(root);
        tail.right = head;
        head.left = tail;
        return head;
    }

    private void traceTree(Node root) {
        if(root == null) {
            return ;
        }
        traceTree(root.left);
        if(tail != null) {
            tail.right = root;
        } else {
            head = root;
        }
        root.left = tail;
        tail = root;
        traceTree(root.right);
    }
}

package com.acm.lico.Solution589;

import java.util.*;

/**
 * Solution589 class
 *
 * @author 格林
 * @date 2021-06-21
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class Solution589 {
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        System.out.println(stack.pop());
        System.out.println(Arrays.toString(stack.toArray()));
    }

}

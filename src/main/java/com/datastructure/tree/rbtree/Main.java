package com.datastructure.tree.rbtree;

/**
 * Main class
 *
 * @author 谢小平
 * @date 2020/4/1
 */
public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer,String> tree = new RedBlackTree<>();
        tree.put(2,"qmd");
        tree.put(1,"xxp");
        tree.put(4,"ddd");
        tree.put(3,"ycy");
        tree.put(3,"ycyycy");

        System.out.println(tree.toString());

    }
}

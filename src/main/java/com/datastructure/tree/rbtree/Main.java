package com.datastructure.tree.rbtree;

/**
 * Main class
 *
 * @author 谢小平
 * @date 2020/4/1
 */
public class Main {
    public static void main(String[] args) {
//        RedBlackTree<String,String> tree = new RedBlackTree<>();
//        tree.put(2,"qmd");
//        tree.put(1,"xxp");
//        tree.put(4,"ddd");
//        tree.put(3,"ycy");
//        tree.put(3,"ycyycy");
//        tree.put("a","a");
//        tree.put("b","b");
//        tree.put("c","c");
//        tree.put("e","d");
//        tree.put("f","e");

        RedBlackTree tree = new RedBlackTree<>();
        tree.put(2,"qmd");
        tree.put(1,"xxp");
        tree.put(4,"ddd");
        tree.put(3,"ycy");
        tree.put(3,"ycyycy");

        tree.levelOrder();
        System.out.println(tree.toString());
        tree.deleteMin();
        System.out.println(tree.toString());
        tree.deleteMax();
        System.out.println(tree.toString());
        tree.delete(3);
        System.out.println(tree.toString());

    }
}

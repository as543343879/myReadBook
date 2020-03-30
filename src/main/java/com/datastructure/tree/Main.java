package com.datastructure.tree;
/**
 * Main class
 *
 * @author 格林
 * @date 2020/3/28
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{5,4,2,3,6,12,2131,12321,21};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for(int i : nums) {
            binarySearchTree.add(i);
        }
        System.out.println(binarySearchTree);
        binarySearchTree.remove(2);
        System.out.println(binarySearchTree);
        binarySearchTree.remove(100);
        System.out.println(binarySearchTree);
        binarySearchTree.remove(12321);
        System.out.println(binarySearchTree);

    }
}

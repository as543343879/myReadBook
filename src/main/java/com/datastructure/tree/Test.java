package com.datastructure.tree;

/**
 * Test class
 *
 * @author 谢小平
 * @date 2020-03-27
 */
public class Test {
    Tree root;
    public static void main(String[] args) {
        Test test = new Test();
        test.test();
//        test.test2(test.root);
//
//        System.out.println(test.root.data);
    }

    private void test2(Tree node) {
       root =  true ? new Tree(2) :  new Tree(3);
        root = new Tree(3);
    }

    public void test() {
         root = new Tree(47);
        Tree treeleft = new Tree(35);
        Tree right = new Tree(37);
        root.left = treeleft;
        treeleft.right = right;


        System.out.println(toString());
//        Tree tree1 = treeleft.right;
//
//        treeleft.right = treeleft.right.right;
//        treeleft.left = treeleft.right.left;
//        treeleft.right = null;
        test3(root);
        System.out.println(toString());
    }
    public void test3(Tree node) {
        Tree parent = node;
        node = node.left;
        parent.left =  node.right;
        node = null;
    }

    class Tree{
        int data;
        Tree left,right;

        public Tree(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }


    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        generateBSTString(root,0,result);
        return result.toString();
    }


    private void generateBSTString(Tree node, int depth, StringBuilder result) {
        if (node == null) {
            result.append(generateBSTString(depth)+"null\n");
            return;
        }
        result.append(generateBSTString(depth)+node.data+"\n");
        generateBSTString(node.left,depth+1,result);
        generateBSTString(node.right,depth+1,result);
    }

    private String generateBSTString(int depth) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            result.append("--");
        }
        return result.toString();
    }
}

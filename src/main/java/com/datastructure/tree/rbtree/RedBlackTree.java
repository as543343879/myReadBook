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

    public void moveflipColors(Node node) {
        node.color = BLACK;
        node.left.color = RED;
        node.right.color = RED;
    }

    private Node balance(Node h){
        if (isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.right) && !isRed(h.left)) h=rotateLeft(h);
        
        if (isRed(h.left) && isRed(h.left.left)) h=rotateRight(h);
        if (isRed(h.left) && isRed(h.right))    flipColors(h);
        h.N = size(h.left)+size(h.right)+1;
        return h;
    }

    private Node moveRedLeft(Node h){
        /**
         * 当前节点的左右子节点都是2-节点，左右节点需要从父节点中借一个节点
         * 如果该节点的右节点的左节点是红色节点，说明兄弟节点不是2-节点，可以从兄弟节点中借一个
         */
        moveflipColors(h);     // 从父节点中借一个
        if(isRed(h.right.left)){    // 判断兄弟节点，如果是非红节点，也从兄弟节点中借一个
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            moveflipColors(h);  //  在从兄弟节点借了一个以后，我们就需要还一个节点给父节点了，因为一开始从父节点那里借了一个
        }
        return h;
    }

    private Node moveRedRight(Node h){
        moveflipColors(h);
        if(isRed(h.left.left)){         // 在这里对于兄弟节点的判断都是.left，因为红色节点只会出现在左边
            h=rotateRight(h);
            moveflipColors(h);
        }
        return h;
    }

    public void delete(Key key){
        if(!isRed(root.left)&& !isRed(root.right)){
            root.color = RED;
        }
        root = delete(root,key);
        if(root != null)
            root.color = BLACK;
    }

    private Node delete(Node h, Key key){
        if(key.compareTo(h.key) < 0){          // 当目标键小于当前键的时候，我们做类似于寻找最小是的操作，向树左边移动，合并父子结点来消除2-结点
            if(h.left == null){
                return null;
            }
            if(isRed(h.left) && !isRed(h.left.left)){
                h = moveRedLeft(h);
            }
            h.left = delete(h.left,key);
        }else{                  // 当目标键大于当前键的时候，我们向右移动，并做与deleteMax相同的操作，如果相同的话，我们使用和二叉树的删除一样的操作，获取当前键的右子树的最小健，然后交换，并将目标键删除
            if(isRed(h.left)){
                h = rotateRight(h);
            }
            if(key != h.key && h.right == null){    // 我们没有找到目标键，我们将其删除
                return null;
            }
            if(!isRed(h.right) && isRed(h.right.left)){
                h = moveRedRight(h);
            }
            if(key == h.key){
                h.value = get(h.right,min(h.right).key);
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            }
            else h.right = delete(h.right,key);
        }
        return balance(h);
    }

    /**
     * 查找以node为根节点红黑树的最小节点
     * 深度优先遍历，递归实现
     *
     * @param node
     * @return BinarySearchTree<E>.Node
     * @author ronglexie
     * @version 2018/8/18
     */
    private Node min(Node node) {
        if(isEmpty()){
            throw new IllegalArgumentException("BinarySearchTree is empty !");
        }
        if(node.left == null){
            return node;
        }
        return min(node.left);
    }

    private boolean isEmpty() {
        return root == null;
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
    public Node rotateRight(Node node) {
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
        if(isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if(isRed(node.left) && isRed(node.right)) flipColors(node);

        node.N = size(node.left) + 1 + size(node.right);
        return node;
    }

    public Node balance(Node node) {
        if(isRed(node.right)) node = rotateLeft(node);
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
        stringBuilder.append(" " + node.key + " : " + node.value + " color " + node.color + " N : " + node.N );
        inTraverse(node.right,stringBuilder);
        return stringBuilder.toString();

    }

}

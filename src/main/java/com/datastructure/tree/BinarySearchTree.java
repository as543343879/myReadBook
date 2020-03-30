package com.datastructure.tree;

/**
 * BinaryTree class
 *
 * @author 格林
 * @date 2020/3/25
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private Node root;
    private int size;

    public E  remove(E e) {
        return remove(root, null, e,true);
    }

    /**
     *  三种情况
     *      node 是叶子节点
     *      node 左子树为空 或者 node 右子树为空
     *      node 左右子树都不为空
     * @param node
     * @param parent
     * @param e
     * @param isleft
     * @return
     */
    private E remove(Node node, Node parent, E e,boolean isleft) {
        if(node == null) {
            return null;
        }
        if(e.compareTo(node.e) > 0) {
           return  remove(node.right,node,e,false);
        } else if(e.compareTo(node.e) < 0) {
           return  remove(node.left,node,e,true);
        } else {
            E returnE = node.e;
            // 假如 左右子树都不为空
            if(node.left != null && node.right != null) {
                //转左，然后向右到尽头(找待删结点的前驱)
                Node s = node.left;
                Node q = node;
                while (s.right != null) {
                    q = s;
                    s = s.right;
                }
                //  s 指向被删除节点
                node.e = s.e;
                if(q != node) {
                    q.right = s.left;
                // 转左 节点没有右了
                } else {
                    q.left = s.left;
                }
            // 删除的是跟节点，并且只有一个子树。 我是通过父节点删除，先解决这种可能导致后面出现null的问题情况。
            }else if(parent == null ) {
                root = root.left != null ? root.left : root.right;
                // 删除节点左节点为空
            } else if(node.left == null) {
                if(isleft) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
                // 删除节点右节点为空
            } else if(node.right == null) {
                if(isleft) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
            }
            return returnE;
        }
    }

    public void add( E e) {
        add(root,null, e);
    }

    private void add(Node node,Node parent, E e) {
        if(parent == null && root == null) {
            root = new Node(e);
            size ++;
        }else if(node == null) {
            if(e.compareTo(parent.e) > 0) {
                parent.right = new Node(e);
            } else {
                parent.left = new Node(e);
            }
            size ++;
        } else if(e.compareTo(node.e) > 0) {
            add(node.right, node,e);
        } else if(e.compareTo(node.e) < 0) {
            add(node.left, node,e);
        }
        return ;
    }


    public boolean contains(E e) {
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }
    }


    private class Node {
        E e;
        Node left,right;
        public void add(){

        }
        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
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
            stringBuilder.append(" " + node.e);
            inTraverse(node.right,stringBuilder);
            return stringBuilder.toString();

    }
}

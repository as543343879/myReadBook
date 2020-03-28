package com.datastructure.tree;

import org.apache.tools.ant.taskdefs.Delete;

import javax.xml.soap.Node;
import java.util.List;

/**
 * BinaryTree class
 *
 * @author 谢小平
 * @date 2020/3/25
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private Node root;
    private int size;

    public E e remove(E e) {
        return root == null ? null :remove(root, null, e,true);
    }

    public E remove(Node node, Node parent, E e,boolean isleft) {
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
            }else if(parent == null ) {
                root = root.left != null ? root.left : root.right;
            } else if(node.left == null) {
                if(isleft) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
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
    /**
     *   根据值查找对应父节点， 如果节点不存在，返回对应结束节点。
     * @param e
     * @return
     */
//    public Node findFather(E e) {
//
//    }




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
}

package com.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * SameTree class
 *
 * @author 谢小平
 * @date 2021/12/2
 */
public class SameTree {



    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public class TreeNode {
        public  int val;
        public TreeNode left;
        public TreeNode right;
        public  TreeNode(int x) { val = x; }

        TreeNode() {}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

        public boolean isSameTree1(TreeNode p, TreeNode q) {
            if(p == null && q ==  null) {
                return true;
            }
            Queue<TreeNode> pQueue = new LinkedList<>();
            pQueue.offer(p);
            Queue<TreeNode> qQueue = new LinkedList<>();
            qQueue.offer(q);
            while(pQueue.size() == qQueue.size()) {
                if(pQueue.size() == 0 && qQueue.size() == 0) {
                    return true;
                }
                TreeNode pPoll = pQueue.poll();
                TreeNode qPoll = qQueue.poll();
                if(pPoll == null && qPoll == null) {
                    continue;
                }
                if(pPoll == null) {
                    return false;
                }
                if(qPoll == null) {
                    return false;
                }
                if(pPoll.val != qPoll.val) {
                    return false;
                }
                pQueue.offer(pPoll.left);
                pQueue.offer(pPoll.right);
                qQueue.offer(qPoll.left);
                qQueue.offer(qPoll.right);
            }
            return false;
        }


    }


package com.acm.lico;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution103 class
 *  103. 二叉树的锯齿形层序遍历
 *  给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * @author 格林
 * @date 2021-06-20
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new LinkedList<>();
        if(root == null) {
            return listList;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean rouShu = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList  = new LinkedList<>();
            int size = nodeQueue.size();
            for(int i = 0; i < size; i ++ ) {
                TreeNode node = nodeQueue.poll();
                if(rouShu) {
                    levelList .offerLast(node.val);
                } else {
                    levelList .offerFirst(node.val);
                }
                if(node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if(node.right != null) {
                    nodeQueue.offer(node.right);
                }
            }
            listList.add(new LinkedList<Integer>(levelList ));
            rouShu = ! rouShu;
        }
        return listList;
    }
}

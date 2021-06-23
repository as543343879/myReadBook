package com.acm.lico;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution102 class
 * 102. 二叉树的层序遍历
 *  给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * @author 格林
 * @date 2021-06-20
 */
public class Solution102 {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return lists;

        cengci(root, 0);

        return lists;
    }

    private void cengci(TreeNode root, int level) {
        if(root == null)
            return ;

        if(level == lists.size()) {
            List<Integer> t = new ArrayList<>();
            t.add(root.val);
            lists.add(t);
        } else  {
            List<Integer> t = lists.get(level);
            t.add(root.val);
        }

        cengci(root.left,level + 1);
        cengci(root.right,level + 1);
    }


}

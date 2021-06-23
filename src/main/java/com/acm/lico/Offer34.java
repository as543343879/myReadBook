package com.acm.lico;

import java.util.ArrayList;
import java.util.List;

/**
 * Offer34 class
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 *  输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * @author 格林
 * @date 2021-06-22
 */
public class Offer34 {
    List<List<Integer>> listList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target);
        return listList;
    }

    private void dfs(TreeNode root, int target) {
        if(root == null )
            return;
        list.add(root.val);
        if(root.left == null && root.right == null && target - root.val == 0) {
            listList.add(new ArrayList<>(list));
        }
        dfs(root.left,target - root.val);
        dfs(root.right,target - root.val);
        list.remove(list.size() - 1);
    }
}

package com.acm.lico;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution113 class
 * 113. 路径总和 II
 *  给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-20
 */
public class Solution113 {
    private List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        dfs(root,targetSum,list);
        return lists;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> list ) {
        if(root == null)
            return ;
        targetSum -= root.val;
        list.add(root.val);
        if(root.left == null && root.right == null && targetSum == 0) {
            lists.add(new LinkedList<Integer>(list));
        }
        dfs(root.left,targetSum,list);
        dfs(root.right,targetSum,list);
        list.remove(list.size() - 1);
    }
}

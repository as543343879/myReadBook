package com.acm.lico;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution257 class
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @author 格林
 * @date 2021-06-20
 */
public class Solution257 {
    private List<String> list = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return list;
    }

    private void dfs(TreeNode root, String path) {
        if(root == null)
            return ;
        StringBuffer pathSB = new StringBuffer(path);
        if(root.left == null && root.right == null) {
            pathSB.append(root.val);
            list.add(pathSB.toString());
            return ;
        }  else {
            pathSB.append(root.val ).append("->");
            dfs(root.left,pathSB.toString());
            dfs(root.right,pathSB.toString());
        }
    }
}

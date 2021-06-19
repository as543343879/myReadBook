package com.acm.lico.Solution515;

import java.util.ArrayList;
import java.util.List;

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
          this.right = right;
     }
  }

/**
 * 515. 在每个树行中找最大值
 */
public  class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getRuslt(root,result,0);
        return result;
    }

    private void getRuslt(TreeNode root, List<Integer> result, int level) {
        if(root == null) {
            return;
        }
        // 新的一层
        if(level == result.size()) {
            result.add(root.val);
        } else {
            if(root.val > result.get(level)) {
                result.set(level,root.val);
            }
        }
        getRuslt(root.left,result,level + 1);
        getRuslt(root.right,result,level+1);
    }
}
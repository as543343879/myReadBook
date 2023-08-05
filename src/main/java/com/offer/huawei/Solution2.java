package com.offer.huawei;

import java.util.*;

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

  public class Solution2 {
    public static void main(String[] args) {
        int[] testData = {1,-1,-3,-2,3};
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        dfs2(root, new ArrayList<>() ,0, targetSum);
        return res;
    }
      public void dfs(TreeNode root, List<Integer> temp, int sum, int targetSum) {
          if(root == null ) {
              if(sum == targetSum ) {
                  res.add(new ArrayList<>(temp));
              }
          }
          if(root.left == null && root.right == null) {
              if(sum == targetSum ) {
                  temp.add(root.val);
                  res.add(new ArrayList<>(temp));
              }
          }
          if(sum > targetSum) {
              return;
          }
          if(root.left != null) {
              temp.add(root.left.val);
              int size = temp.size();
              dfs(root.left, temp, sum + root.left.val , targetSum );
              temp.remove(size - 1);
          }
          if(root.right != null) {
              temp.add(root.right.val);
              int size = temp.size();
              dfs(root.right, temp, sum + root.right.val , targetSum );
              temp.remove(size - 1);
          }

      }



  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      dfs2(root, new ArrayList<>() ,0, targetSum);
      return res;
  }
    public void dfs2(TreeNode root, ArrayList<Integer> temp, int sum, int targetSum) {
        if(root == null ) {
            return;
        }
        sum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null) {
            if(sum == targetSum ) {
                res.add(new ArrayList<>(temp));
            }
        }
        int size = temp.size();
        dfs2(root.left, temp, sum , targetSum );
        dfs2(root.right, temp, sum , targetSum );
        temp.remove(size-1);
    }
}
package com.acm.lico.tree;


import java.util.LinkedList;
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
 * Solution1022 class
 *1022. 从根到叶的二进制数之和
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 *
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * @author 谢小平
 * @date 2022/5/30
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。
 递归
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注 执行用时： 2 ms ,
 在所有 Java 提交中击败了 16.24% 的用户 内存消耗： 40.7 MB ,
 在所有 Java 提交中击败了 63.83% 的用户 通过测试用例： 63 / 63
 */
public class Solution1022 {
    List<String> list = new LinkedList<>();
    public int sumRootToLeaf(TreeNode root) {
        recursion(root, "");
        int res = 0;
        System.out.println(list.size());
        int len = list.size();
        for(String key: list) {
            if (len >= 2 && key.length() == 1) {
                continue;
            }
            res+= Integer.valueOf(key,2);
        }
        return res;
    }

    public void  recursion(TreeNode root, String str) {
        if(root == null) {
            return;
        }
        StringBuilder sbr = new StringBuilder(str);
        sbr.append(root.val);
        if (root.left == null && root.right == null) {
            list.add(sbr.toString());
            list.add(str);
        }
        recursion(root.left, sbr.toString());
        recursion(root.right, sbr.toString());
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("0101", 2));
    }

//    public void  recursion(TreeNode root, StringBuilder sbr) {
//        if(root == null) {
//            return;
//        }
//        sbr.append(root.val);
//        if (root.left == null && root.right == null) {
//            list.add(sbr.toString());
//            return ;
//        }
//        int len = sbr.length();
//        recursion(root.left, sbr);
//        recursion(root.right, sbr);
//        sbr.deleteCharAt(len-1);
//    }
}

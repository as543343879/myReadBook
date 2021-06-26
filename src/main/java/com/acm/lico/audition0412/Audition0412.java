package com.acm.lico.audition0412;

/**
 * audition0412 class
 *面试题 04.12. 求和路径
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-20
 */
class TreeNode {
     int val;
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }

public class Audition0412 {
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return pathSum(root.left,sum) + pathSum(root.right,sum) + countSum(root, sum);
    }

    public int countSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
       int res =  root.val == sum ? 1 : 0;
        sum -= root.val;
       return countSum(root.left,sum) + countSum(root.right,sum) + res;
    }
}

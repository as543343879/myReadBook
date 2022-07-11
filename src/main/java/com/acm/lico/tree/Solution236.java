package com.acm.lico.tree;

/**
 * Solution236 class
 *236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 *
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 * @author 格林
 * @date 2022-07-11
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(N)
 空间复杂度
 O(N)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。
 后续遍历
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 6 ms , 在所有 Java 提交中击败了 100.00% 的用户
 内存消耗： 43.3 MB , 在所有 Java 提交中击败了 6.83% 的用户
 通过测试用例： 31 / 31
 */
public class Solution236 {


    public TreeNode lowestCommonAncestor(TreeNode   root, TreeNode p, TreeNode q) {
        return find(root,p,q);
    }

    public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        TreeNode leftRes = find(root.left, p, q);
        TreeNode rightRes = find(root.right, p, q);
        if(leftRes != null && rightRes != null) {
            return root;
        }


        if(( root.val == p.val  || root.val == q.val) && (leftRes != null || rightRes != null) ) {
            return root;
        }  else if(root.val == p.val  || root.val == q.val) {
            return root;
        } else if(leftRes != null) {
            return leftRes;
        }
        else if(rightRes != null) {
            return rightRes;
        }
        else {
            return null;
        }

    }
}

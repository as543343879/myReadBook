package com.acm.lico.tree; /**
 129 ,求根节点到叶节点数字之和
 //给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 //
 //
 //
 // 每条从根节点到叶节点的路径都代表一个数字：
 //
 //
 //
 //
 // 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 //
 //
 // 计算从根节点到叶节点生成的 所有数字之和 。
 //
 // 叶节点 是指没有子节点的节点。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：root = [1,2,3]
 //输出：25
 //解释：
 //从根到叶子节点路径 1->2 代表数字 12
 //从根到叶子节点路径 1->3 代表数字 13
 //因此，数字总和 = 12 + 13 = 25
 //
 // 示例 2：
 //
 //
 //输入：root = [4,9,0,5,1]
 //输出：1026
 //解释：
 //从根到叶子节点路径 4->9->5 代表数字 495
 //从根到叶子节点路径 4->9->1 代表数字 491
 //从根到叶子节点路径 4->0 代表数字 40
 //因此，数字总和 = 495 + 491 + 40 = 1026
 //
 //
 //
 //
 // 提示：
 //
 //
 // 树中节点的数目在范围 [1, 1000] 内
 // 0 <= Node.val <= 9
 // 树的深度不超过 10
 //
 //
 // Related Topics 树 深度优先搜索 二叉树 👍 589 👎 0

 **/
/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 sumNumbers1
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 深度搜索 或者广度搜索。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 sumNumbers1:
 解答成功:
 执行耗时:9 ms,击败了5.54% 的Java用户
 内存消耗:39.9 MB,击败了5.12% 的Java用户

 sumNumbers:
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:39.1 MB,击败了51.31% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution129 {

    public int sumNumbers(TreeNode root) {
        return dfs2(root,0);
    }

    private int dfs2(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs2(root.left,sum) + dfs2(root.right, sum);
        }
    }

    public int sumNumbers1(TreeNode root) {
        List<String> resList = dfs(root);
        int res = 0;
        for(String str : resList) {
            res += Integer.valueOf(str);
        }
        return res;
    }

    public List<String> dfs(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<String> leftRes = dfs(root.left);
        List<String> rightRes = dfs(root.right);
        List<String> arrayList = new ArrayList<>(leftRes.size() + rightRes.size() + 1);
        for(String str : leftRes ) {
            arrayList.add(root.val + str);
        }
        for(String str : rightRes ) {
            arrayList.add(root.val + str);
        }
        if(arrayList.size() ==0) {
            arrayList.add(String.valueOf(root.val));
        }
        return arrayList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

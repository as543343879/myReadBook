package com.acm.lico.tree; /**
 * 538 ,把二叉搜索树转换为累加树
 * //给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于
 * // node.val 的值之和。
 * //
 * // 提醒一下，二叉搜索树满足下列约束条件：
 * //
 * //
 * // 节点的左子树仅包含键 小于 节点键的节点。
 * // 节点的右子树仅包含键 大于 节点键的节点。
 * // 左右子树也必须是二叉搜索树。
 * //
 * //
 * // 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-
 * //sum-tree/ 相同
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //
 * // 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * //输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * //
 * //
 * // 示例 2：
 * //
 * // 输入：root = [0,null,1]
 * //输出：[1,null,1]
 * //
 * //
 * // 示例 3：
 * //
 * // 输入：root = [1,0,2]
 * //输出：[3,3,2]
 * //
 * //
 * // 示例 4：
 * //
 * // 输入：root = [3,2,4,1]
 * //输出：[7,9,4,10]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 树中的节点数介于 0 和 10⁴ 之间。
 * // 每个节点的值介于 -10⁴ 和 10⁴ 之间。
 * // 树中的所有值 互不相同 。
 * // 给定的树为二叉搜索树。
 * //
 * //
 * // Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 840 👎 0
 * <p>
 * <p>
 * 1 复杂度分析
 * 估算问题中复杂度的上限和下限
 * 时间复杂度
 * 空间复杂度
 * O(1) 一个常量下完成
 * O(n) 一次遍历
 * O(logn) 折半查询
 * O(n^2) 两重嵌套循环查询
 * 2 定位问题
 * 根据问题类型，确定采用何种算法思维。
 * 例如
 * 这个问题是什么类型（排序、查找、最优化）的问题；
 * 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 * 采用哪些数据结构或算法思维，能把这个问题解决。
 * 自己思路：
 * 右子树，跟节点，左子树。
 * 跟结点 = 跟节点+ 右子树的值
 * 左子树 = 跟节点+ 左节点的值
 * <p>
 * 3 数据操作分析
 * 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 * 4 编码实现
 * 5 执行结果
 * 自己思路：
 * 解答成功:
 * 执行耗时:0 ms,击败了100.00% 的Java用户
 * 内存消耗:41.5 MB,击败了75.03% 的Java用户
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
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 右子树，跟节点，左子树。
 跟结点 = 跟节点+ 右子树的值
 左子树 = 跟节点+ 左节点的值

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:41.5 MB,击败了75.03% 的Java用户

 官方思路： 用一个全局变量记录信息。
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:41.3 MB,击败了91.69% 的Java用户

 */
//leetcode submit region begin(Prohibit modification and deletion)

import com.acm.lico.offer68.TreeNode;

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
class Solution538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public TreeNode convertBST2(TreeNode root) {
        trace(root, 0);
        return root;
    }

    public int trace(TreeNode root, int preValue) {
        if (root == null) {
            return 0;
        }
        int rightCount = trace(root.right, preValue);
        if (root.right == null) {
            root.val += rightCount + preValue;
        } else {
            root.val += rightCount;
        }
        preValue = root.val;
        if (root.left != null) {
            rightCount = trace(root.left, preValue);
            return rightCount;
        }

        return root.val;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

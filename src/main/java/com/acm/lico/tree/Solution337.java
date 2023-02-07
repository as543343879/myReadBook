package com.acm.lico.tree; /**
 * 337 ,打家劫舍 III
 * //小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为
 * // root 。
 * //
 * // 除了
 * // root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的
 * //房子在同一天晚上被打劫 ，房屋将自动报警。
 * //
 * // 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //
 * //
 * //输入: root = [3,2,3,null,3,null,1]
 * //输出: 7
 * //解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * //
 * // 示例 2:
 * //
 * //
 * //
 * //
 * //输入: root = [3,4,5,1,3,null,1]
 * //输出: 9
 * //解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * //
 * //
 * //
 * // 树的节点数在 [1, 10⁴] 范围内
 * // 0 <= Node.val <= 10⁴
 * //
 * //
 * // Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1483 👎 0
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
 * 层级遍历，每选一个，后面那个就不选。 思路错误。
 * 修改思路：
 * 第一个选，或者不选两种情况， 后面
 * <p>
 * 3 数据操作分析
 * 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 * 4 编码实现
 * 5 执行结果
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


 官网思路：
 时间复杂度：O(N)
 空间复杂度: O(N)

 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 层级遍历，每选一个，后面那个就不选。 思路错误。
 修改思路：
 第一个选，或者不选两种情况， 时间超限。

 官网思路：
 候选遍历 动态规划  ： 也是将待求解的问题分解为若干个子问题（阶段），按顺序求解子阶段，前一子问题的解，为后一子问题的求解提供了有用的信息。
 f(x) ： 表示选x = x.val + g(x.left) + g(x.right);
 g(x) : 表示不选x =  max( f(x.left), g(x.left))  +  max( f(x.right), g(x.right))
 get(root) = max(f(x),g(x)

 官网思路2：
 官网思路：上 省去map 的空间开销


 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果

 官网思路：
 解答成功:
 执行耗时:3 ms,击败了17.07% 的Java用户
 内存消耗:41.1 MB,击败了46.88% 的Java用户

 官网思路2：
 解答成功:
 执行耗时:3 ms,击败了17.07% 的Java用户
 内存消耗:41.4 MB,击败了10.56% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)


import com.acm.lico.offer68.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
class Solution337 {
    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();

    public int rob(TreeNode root) {
//        int res = trace2(root, false);
//        res = Math.max(res, trace(root, false));
        traceAfter(root);
//        get(root) = max(f(x),g(x)
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root,0));
    }

    public void traceAfter(TreeNode root) {
        if(root == null) {
            return;
        }
        traceAfter(root.left);
        traceAfter(root.right);
//        f(x) ： 表示选x = x.val + g(x.left) + g(x.right);
//        g(x) : 表示不选x =  max( f(x.left), g(x.left))  +  max( f(x.right), g(x.right))
        f.put(root, root.val + g.getOrDefault(root.left,0) + g.getOrDefault(root.right,0));
        g.put(root, Math.max(f.getOrDefault(root.left,0), g.getOrDefault(root.left,0)) + Math.max(f.getOrDefault(root.right,0), g.getOrDefault(root.right,0)) );
    }

    /**
     * 0 是选
     * 1 是不选
     * @param root
     * @return
     */
    public int[] traceAfter2(TreeNode root) {
        if(root == null) {
            return new int[]{0,0};
        }
        int[] left = traceAfter2(root.left);
        int[] right = traceAfter2(root.right);
//        f(x) ： 表示选x = x.val + g(x.left) + g(x.right);
//        g(x) : 表示不选x =  max( f(x.left), g(x.left))  +  max( f(x.right), g(x.right))

        int[] res = new int[2];

        res[0] = root.val + left[1] + right[1];

        res[1] = Math.max(left[0],left[1]) + Math.max( right[0], right[1]);

        return res;

    }

    /**
     *
     * @param root 节点
     * @param isChoose 上个一节点是否选择
     * @return
     * 结果：Time Limit Exceeded
     */
    public int trace2(TreeNode root, boolean isChoose) {
        if(root == null) {
            return 0;
        }
        // 上个节点选择了，子节点，一定不能选择。
        if(isChoose) {
            int res = trace2(root.left, false);
            res += trace2(root.right, false);
            return res;
            // 上一个节点没选择， 这个节点 选或者不选都有判断
        } else {
            int res = root.val;
            res += trace2(root.left, true);
            res += trace2(root.right, true);

            int res2 = trace2(root.left, false);
            res2 += trace2(root.right, false);

            return Math.max(res,res2);
        }
    }

    public int trace(TreeNode root, boolean isChoose) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (isChoose) {
            res = root.val;
            res += trace(root.left, !isChoose);
            res += trace(root.right, !isChoose);
        } else {
            int lefValue = trace(root.left, !isChoose);
            int leftValue2 = trace(root.left, isChoose);
            res += Math.max(leftValue2, lefValue);
            int rightValue = trace(root.right, !isChoose);
            int rightvalue2 = trace(root.right, isChoose);
            res += Math.max(rightValue, rightvalue2);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

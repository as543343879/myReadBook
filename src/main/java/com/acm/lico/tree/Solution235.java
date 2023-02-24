/**
 235 ,二叉搜索树的最近公共祖先
 //给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 //
 // 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
 //一个节点也可以是它自己的祖先）。”
 //
 // 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
 //
 //
 //
 //
 //
 // 示例 1:
 //
 // 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 //输出: 6
 //解释: 节点 2 和节点 8 的最近公共祖先是 6。
 //
 //
 // 示例 2:
 //
 // 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 //输出: 2
 //解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 //
 //
 //
 // 说明:
 //
 //
 // 所有节点的值都是唯一的。
 // p、q 为不同节点且均存在于给定的二叉搜索树中。
 //
 //
 // Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1024 👎 0

 **/
/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询

 官方思路递归：
 时间复杂度O(N)
 空间复杂度O(N)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 应该是用后序遍历， 递归不断返回 左右节点的的祖先节点。 当两个 节点祖先节点一致，就是最近公共祖先。

 官方思路：
 如果当前节点 ，大于 pq节点， 说明 最近公共祖先 在左侧
 如果当前节点， 小于 pq节点， 说明 最近公共祖先 在右侧。
 其他情况， 当前节点是分叉节点，或者 p，q等于当前节点。 就是 最近公共祖先。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 官方思路： lowestCommonAncestor3
 解答成功:
 执行耗时:5 ms,击败了99.95% 的Java用户
 内存消耗:42.4 MB,击败了46.42% 的Java用户

 官方思路： lowestCommonAncestor 非递归
 解答成功:
 执行耗时:5 ms,击败了99.95% 的Java用户
 内存消耗:42.4 MB,击败了46.83% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)

import com.acm.lico.offer68.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if(p.val > root.val && q.val > root.val  ) {
                root =  root.right;
            } else if(root.val > p.val && root.val > q.val) {
                root =  root.left;
            } else {
                break;
            }
        }
        return root;
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }
        if(p.val > root.val && q.val > root.val  ) {
            return lowestCommonAncestor3(root.right, p, q);
        } else if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor3(root.left, p, q);
        } else {
            return root;
        }
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }
        if(root == p || root == q) {
            return root;
        }
        TreeNode parentLeft =  lowestCommonAncestor(root.left, p, q);
        TreeNode parentRight =  lowestCommonAncestor(root.right, p, q);
        if(parentRight == parentRight) {
            return parentRight;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

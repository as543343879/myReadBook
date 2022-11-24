package com.acm.lico.dp;
// 不同的二叉搜索树
//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2005 👎 0
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
numTrees
     时间复杂度 O(N^2)
     空间复杂度 O(N)
 2 定位问题
根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。

 动态规划：
dp[n] 表示 N节点组成的二叉搜索树
Fn[i，n] 表示以i为跟节点 N节点组成的二叉树搜索数的个数
Fn[i,n] = dp[i-1] + dp[n-i]; 错误；Fn[i,n] = dp[i-1] * dp[n-i];
dp[n] = (1到n) Fn(i,n)

 dp[1] = 1;

 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:38.1 MB,击败了75.59% 的Java用户
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution96 {
    public int numTrees(int n) {
        int[] dp = new int[n +1];
        dp[1] = 1;
        dp[0] = 1;
        for(int i = 2; i <= n; i ++) {
            for(int j = 1; j <= i; j ++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return  dp[n];
    }
    /**
     * 错误 思路都没有乱作
     * @param n
     * @return
     */
    public int numTrees2(int n) {
        if(n == 1) {
            return 1;
        }  else if(n == 2) {
            return 2;
        }
        int[]  dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <=n ; i ++) {
            dp[i] = dp[i-1] + i;
        }
        return dp[n];
    }
}

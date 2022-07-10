package com.acm.lico.dp;

/**
 * Solution300 class
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 *300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * @author 格林
 * @date 2022-07-10
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 56 ms
     时间复杂度: O(N^2)
     空间复杂度: O(N)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。
 动态规划
 dp[i] = max(dp[0...j]) + 1  其中 0 < j < i 并且 nums[j] < nums[i];
    拆分为子问题，上一步子问题，对下一步子问题提供支持。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
public class Solution300 {
    /**
     * 执行结果： 通过 显示详情 添加备注 执
     * 行用时： 56 ms , 在所有 Java 提交中击败了 41.95% 的用户
     * 内存消耗： 41.4 MB , 在所有 Java 提交中击败了 5.15% 的用户
     * 通过测试用例： 54 / 54
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i ++){
            dp[i] = 1;
            for(int j = 0; j < i; j ++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }
}

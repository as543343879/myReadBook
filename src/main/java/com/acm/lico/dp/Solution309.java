package com.acm.lico.dp; /**
 309 ,最佳买卖股票时机含冷冻期
 //给定一个整数数组
 // prices，其中第 prices[i] 表示第 i 天的股票价格 。
 //
 // 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 //
 //
 // 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 //
 //
 // 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 //
 //
 //
 // 示例 1:
 //
 //
 //输入: prices = [1,2,3,0,2]
 //输出: 3
 //解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 //
 // 示例 2:
 //
 //
 //输入: prices = [1]
 //输出: 0
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= prices.length <= 5000
 // 0 <= prices[i] <= 1000
 //
 //
 // Related Topics 数组 动态规划 👍 1357 👎 0

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
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 动态规划
 dp[i][0] 表示持有股票
 dp[i][1] 表示不持有股票，处于冷冻期
 dp[i][2] 表示不持有股票，不处于冷冻期
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:1 ms,击败了77.52% 的Java用户
 内存消耗:39.7 MB,击败了50.81% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = - prices[0];
        for(int i = 1; i < n; i ++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(dp[n-1][1], dp[n-1][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

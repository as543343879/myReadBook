package com.acm.lico.dp; /**
 * 122 ,买卖股票的最佳时机 II
 * //给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * //
 * // 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * //
 * // 返回 你能获得的 最大 利润 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：prices = [7,1,5,3,6,4]
 * //输出：7
 * //解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * //     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * //     总利润为 4 + 3 = 7 。
 * //
 * // 示例 2：
 * //
 * //
 * //输入：prices = [1,2,3,4,5]
 * //输出：4
 * //解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * //     总利润为 4 。
 * //
 * // 示例 3：
 * //
 * //
 * //输入：prices = [7,6,4,3,1]
 * //输出：0
 * //解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= prices.length <= 3 * 10⁴
 * // 0 <= prices[i] <= 10⁴
 * //
 * //
 * // Related Topics 贪心 数组 动态规划 👍 2063 👎 0
 **/


/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询

 自己思路：
 时间复杂度 O(N)
 空间复杂度 O(N)

 O(n^2) 两重嵌套循环查询
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 dp[i][2]
 dp[i][0] 持有股的最大收益
 dp[i][1] 不持有股的最大收益
 dp[i][0] = max(dp[i][0] , dp[i-][1]  - prices[i]);
 dp[i][1] = max(dp[i][1] ,dp[i-1][0] + prices[i]);
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution122 {

    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N)
     空间复杂度  O(N)
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
     思路： 动态规划， dp[0][i] 持有股票 最大利润， dp[1][i] 表示 i 不持有股票 最大利润
     1. 动态转移方程 dp[0][i] = max(dp[0][i-1] - num[i], dp[0][i-1]), dp[1][i] = max(dp[0][i-1] + num[i] ，dp[0][i-1]);
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:2 ms,击败了35.12% 的Java用户
     内存消耗:43.2 MB,击败了35.94% 的Java用户
     */
    public int maxProfitNew20(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int dp[][] = new int[2][n];
        dp[0][0] = - prices[0];
        dp[1][0] = 0;;
        for(int i = 1; i < prices.length; i ++) {
            dp[1][i] = Math.max(dp[0][i-1] + prices[i], dp[1][i-1]);
            dp[0][i] = Math.max(dp[1][i-1] - prices[i], dp[0][i-1]);
        }
        return dp[1][prices.length-1];
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[len - 1][1];

    }
    /**
     * old 的方法
     * Si[1] 持有股票 = max{S[i-1][1],S[i-1][0] - price[i] }
     * Si[0] 没有持有股票 = max{S[i-1][0],S[i-1][1] + price[i] }
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int pricesLen = prices.length;
//        if(pricesLen == 1) {
//            return prices[0];
//        }
        int [][] dp = new int[pricesLen][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < pricesLen; i ++) {
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
        }
        return Math.max(dp[pricesLen-1][0],dp[pricesLen-1][1]);
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Solution122().maxProfit(prices));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

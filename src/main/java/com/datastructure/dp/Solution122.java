package com.datastructure.dp;

/**
 * Solution122 class
 *122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 谢小平
 * @date 2021/11/18
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(n) 一次遍历
 空间复杂度
    O(n) 一次遍历
 2 定位问题
根据问题类型，确定采用何种算法思维。
   dp
 3 数据操作分析
    数组
 4 编码实现
 5 执行结果
     执行结果： 通过 显示详情 添加备注
     执行用时： 3 ms , 在所有 Java 提交中击败了 23.29% 的用户
     内存消耗： 37.9 MB , 在所有 Java 提交中击败了 86.59% 的用户
     通过测试用例： 200 / 200
 */
public class Solution122 {
    /**
     * Si[1] 持有股票 = max{S[i-1][1],S[i-1][0] - price[i] }
     * Si[0] 没有持有股票 = max{S[i-1][0],S[i-1][1] + price[i] }
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
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

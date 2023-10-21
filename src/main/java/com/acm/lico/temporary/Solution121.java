package com.acm.lico.temporary; /**
 121 ,买卖股票的最佳时机
 //给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 //
 // 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 //
 // 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：[7,1,5,3,6,4]
 //输出：5
 //解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 //     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 //
 //
 // 示例 2：
 //
 //
 //输入：prices = [7,6,4,3,1]
 //输出：0
 //解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= prices.length <= 10⁵
 // 0 <= prices[i] <= 10⁴
 //
 //
 // Related Topics 数组 动态规划 👍 2905 👎 0

 **/

import com.acm.lico.temporary.Solution121;

/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询
 自己思路：
 时间复杂度 O(N)
 空间复杂度 O(1)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 只能买卖一笔。
 在最低的时候买入， 最高的时候卖出。
 //    dp[i][2]
 //        dp[i][0] 持有股的最大收益
 //        dp[i][1] 不持有股的最大收益
 //    dp[i][0] = max(dp[i][0] , dp[i-][1]  - prices[i]);
 //    dp[i][1] = max(dp[i][1] ,dp[i-1][0] + prices[i]);
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:1 ms,击败了100.00% 的Java用户
 内存消耗:57.2 MB,击败了71.13% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution121 {
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N)
     空间复杂度  O(1)
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
     思路：
     1. 记录最低价格，能赚钱 就卖出， 记录最大值。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:1 ms,击败了100.00% 的Java用户
     内存消耗:57.6 MB,击败了44.26% 的Java用户
     */
    public int maxProfitNew20(int[] prices) {
        int res = 0;
        if(prices == null || prices.length == 0 ){
            return res;
        }
        int min = prices[0];
        for(int i = 1; i < prices.length; i ++) {
            if(prices[i] - min > res) {
                res = prices[i] - min;
            }
            if(prices[i] < min) {
                min = prices[i];
            }
        }
        return res;
    }
    public int maxProfit(int[] prices) {
        int minPrices = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0 ; i < prices.length; i ++) {
            if(prices[i] < minPrices ) {
                minPrices = prices[i];
            } else {
                res = Math.max(res, prices[i] - minPrices);
            }
        }
        return res;
    }

    /**
     * 以前的记录
     * @param prices
     * @return
     */
    public int maxProfitOld(int[] prices) {
        int lowestPrice = prices[0];
        int makeTheMostMoney = 0;

        for(int i = 1; i < prices.length; i ++) {
            if(prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            } else if( ( prices[i] - lowestPrice ) > makeTheMostMoney) {
                makeTheMostMoney = prices[i] - lowestPrice;
            }
        }
        return makeTheMostMoney;
    }

    /**
     * 贪心策略错误
     * @param prices
     * @return
     */
    public int maxProfitERROR(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int leftMin = 0;
        int rightMax = prices.length - 1;
        int left = 1;
        int right =  prices.length - 2;
        while (left < prices.length && right > 0 && left <= right  ) {

            if(prices[left] < prices[leftMin]) {
                if(left >= rightMax) {
                    break;
                }
                leftMin = left;
            }
            if(prices[right] > prices[rightMax]) {
                if(right <= leftMin) {
                    break;
                }
                rightMax = right;
            }
            left ++;
            right --;
        }
        int res = prices[rightMax] - prices[leftMin];
        return res < 0 ? 0 : res;
    }

    public static void main(String[] args) {
        int[] req ={2,7,1,4};
        System.out.println(new Solution121().maxProfit(req));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

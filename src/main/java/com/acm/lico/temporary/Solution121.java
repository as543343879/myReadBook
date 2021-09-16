package com.acm.lico.temporary;

/**
 * Solution121 class
 *121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * @author 谢小平
 * @date 2021/9/16
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
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 6 总结
    一次遍历 做两件相关的事情
 执行结果： 通过 显示详情 添加备注
 执行用时： 2 ms , 在所有 Java 提交中击败了 94.88% 的用户
 内存消耗： 51.3 MB , 在所有 Java 提交中击败了 65.61% 的用户
 通过测试用例： 211 / 211
 */
public class Solution121 {

    public int maxProfit(int[] prices) {
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

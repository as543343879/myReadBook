package com.acm.lico;

/**
 * Offer63 class
 * 剑指 Offer 63. 股票的最大利润
 *假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-22
 */
public class Offer63 {

    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i < prices.length; i ++) {
            for(int j = i + 1; j < prices.length; j ++) {
                if(i != j && prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i ++) {
           if(prices[i] < min) {
               min = prices[i];
           } else if(prices[i] - min > max) {
               max = prices[i] - min;
           }
        }
        return max;
    }
}
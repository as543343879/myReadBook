package com.acm.lico.doNotKnow;

/**
 * Solution322 class
 * https://leetcode.cn/problems/coin-change/
 *322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * @author 格林
 * @date 2022-07-18
 */

import java.util.Arrays;

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
 动态规划
 dp[i] = k + dp[i-k]

 dfs + 减枝dp
 dp[k] = 1 + dp[k-C]
 直接dfs  回溯所有路径，每条路径都走一遍，寻找最小值。

根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
public class Solution322 {
    int res = Integer.MAX_VALUE;

    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 37 ms , 在所有 Java 提交中击败了 8.27% 的用户
     * 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 20.56% 的用户
     * 通过测试用例： 189 / 189
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        return getCoinChange(coins, amount,new int[amount]);
    }

    private int getCoinChange(int[] coins, int amount, int[] dp ) {
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }
        if(dp[amount -1] != 0) {
            return dp[amount-1];
        }
        int min = Integer.MAX_VALUE;
        //  dp[k] = 1 + dp[k-C]
        for(int i: coins) {
            int res = getCoinChange(coins, amount - i, dp);
            if(res >= 0 && res < min) {
                min = res  + 1;
            }
        }
        dp[amount - 1] = min == Integer.MAX_VALUE ? -1: min;
        return dp[amount -1];
    }

    /**
     * 时间超限 要进行减枝
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        for(int i = 0; i < coins.length; i ++) {
            dfs(coins,amount - coins[i], 1, i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int[] coins, int amount, int count, int index) {
        if(amount < 0) {
            return;
        } else if( amount == 0) {
            if(count < res){
                res = count;
            }
            return ;
        }
        for(int i = index; i < coins.length; i ++) {
            dfs(coins, amount - coins[i], count + 1,i );
        }

    }

    // TODO
    public int coinChange2(int[] coins, int amount) {
        int count = 0;

        Arrays.sort(coins);
        if(amount == 0) {
            return 0;
        }
        for(int j = coins.length - 1; j >= 0; j-- ) {
            int t = amount;
            for(int i = j; i >=0; i --) {
                if (coins[i] <= t) {
                    count += t / coins[i];
                    t = t % coins[i];
                    if(t == 0) {
                        return count;
                    }
                }

            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] testData = {186,419,83,408};
        System.out.println(new Solution322().coinChange(testData, 6249));
    }
}

package com.acm.lico.doNotKnow;

/**
 * Solution279 class
 * https://leetcode.cn/problems/perfect-squares/
 *279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * 提示：
 *
 * 1 <= n <= 104
 * 通过次数307,372提交次数471,071
 * @author 格林
 * @date 2022-07-13
 */

import javax.validation.constraints.Max;

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
 没想到是dp
 i = j^2 + i-j*j
 f[i] 表示最少多少个平方数表示i
 f[i] = 1 + f[i- j*j]
 dp 子问题 最优解不确定，就循环啊。
 j确定不了 就循环 取最优解

根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 20 ms , 在所有 Java 提交中击败了 91.06% 的用户
 内存消耗： 40.8 MB , 在所有 Java 提交中击败了 30.31% 的用户
 通过测试用例： 588 / 588
 */
public class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i ++) {
            int min = Integer.MAX_VALUE;
            for(int k = 1; k * k <=i; k++) {
                min = Math.min(min, 1 + dp[i - k*k]);
            }
            dp[i] = min;
        }
        return dp[n];
    }
    /**
     * 贪心贪最大的 思路错了
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        int res = 0;
        int t = n;
        t = (int) Math.sqrt(n);
        if( t*t == n) {
            return 1;
        } else if( n % t == 0  ) {
            int x = n / t;
            int i = (int) Math.sqrt(x);
            if(i * i == x) {
                return t;
            }
        }

        while (n > 0) {
            t = (int) Math.sqrt(n);
            int last = n - t * t;
            if(t == 1) {
                res += n ;
                break;
            }else {
                res++;
            }
            n = last;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Solution279().numSquares(18));
        System.out.println(Math.sqrt(12));
    }
}

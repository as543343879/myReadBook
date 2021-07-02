package com.acm.lico;

/**
 * Solution70 class
 *70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * @author 格林
 * @date 2021-07-02
 */
public class Solution70 {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        int[] t = new int[n];
        t[0] = 1;
        t[1] = 2;
        for(int i = 2; i < n; i ++ ) {
            t[i] = t[i-1] + t[i-2];
        }
        return t[n - 1] ;
    }
    public static void main(String[] args) {
        new Solution70().climbStairs(2);
    }


}

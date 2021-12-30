package com.acm.lico.dp;

import java.util.Arrays;

/**
 * Solution1575 class
 *https://leetcode-cn.com/problems/count-all-possible-routes/
 * 1575. 统计所有可行路径
 * 给你一个 互不相同 的整数数组，其中 locations[i] 表示第 i 个城市的位置。同时给你 start，finish 和 fuel 分别表示出发城市、目的地城市和你初始拥有的汽油总量
 *
 * 每一步中，如果你在城市 i ，你可以选择任意一个城市 j ，满足  j != i 且 0 <= j < locations.length ，并移动到城市 j 。从城市 i 移动到 j 消耗的汽油量为 |locations[i] - locations[j]|，|x| 表示 x 的绝对值。
 *
 * 请注意， fuel 任何时刻都 不能 为负，且你 可以 经过任意城市超过一次（包括 start 和 finish ）。
 *
 * 请你返回从 start 到 finish 所有可能路径的数目。
 *
 * 由于答案可能很大， 请将它对 10^9 + 7 取余后返回。
 * @author 谢小平
 * @date 2021/12/23
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
    每次递归操作次数*每次递归的操作次数 = n*fuel*n
    O(n^2*fuel)
 空间复杂度
    O(n*fuel)
 2 定位问题
根据问题类型，确定采用何种算法思维。
 - 记忆搜索
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 109 / 109 个通过测试用例
 状态：通过
 执行用时: 51 ms
 内存消耗: 38 MB
 */
public class Solution1575_2 {
    static final int MOD = 1000000007;
    int[][] dp;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        dp = new int[locations.length][fuel+1];
        Arrays.stream(dp).forEach(i -> Arrays.fill(i,-1));
        dfs(locations,start,finish,fuel);
        return dp[start][fuel];
    }

    /**
     *我们用 f[\textit{pos}][\textit{rest}]f[pos][rest] 表示当我们当前位于第 \textit{pos}pos 个城市，剩余的汽油量为 \textit{rest}rest 时，到达终点 \textit{finish}finish 的可能的路径总数。
     *dp[pos][rest] 第pos个城市，剩余的汽油量为rest时， 到达终点 finish 的可能路径总数。
     *
     * dp[pos][rest] = sum( dp[i][rest-cost(post,i) ]  )
     *
     */
    private int dfs(int[] locations, int start, int finish, int fuel) {
         if(dp[start][fuel] != -1 ) {
             return dp[start][fuel];
         }
        dp[start][fuel] = 0;
         if((fuel < Math.abs(locations[start]-locations[finish])) ) {
             return 0;
         }

         for(int i = 0 ; i < locations.length; i ++) {
             int cost = Math.abs(locations[start]-locations[i]);
            if(i != start && fuel   >= cost ) {
                dp[start][fuel] += dfs(locations,i,finish,fuel - cost );
                dp[start][fuel] %= MOD;
            }
         }
        if (start == finish) {
            dp[start][fuel] += 1;
            dp[start][fuel] %= MOD;
        }


        return   dp[start][fuel];
    }

    public static void main(String[] args) {
//        int[] locations = {2,3,6,8,4};
//        int start = 1, finish = 3, fuel = 5;
        int[] locations = {1,2,3};
        int start = 0, finish = 2, fuel = 40;

        System.out.println(new Solution1575_2().countRoutes(locations,start,finish,fuel));
    }
}

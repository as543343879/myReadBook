package com.acm.lico.dp;

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
 *
 *
 * @author 谢小平
 * @date 2021/12/23
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
 */
public class Solution1575 {
    private int rest = 0;
    static final int MOD = 1000000007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        dfs(locations,start,finish,fuel);
        return rest;
    }




    /**
     * 时间超限
     * @param locations
     * @param start
     * @param finish
     * @param fuel
     */
    private void dfs(int[] locations, int start, int finish, int fuel) {
        if(fuel < 0 ){
            return ;
        } else if(fuel >= 0 && start == finish) {
            rest ++;
            rest %= MOD;
        }

        for(int i = 0; i < locations.length; i ++ ) {
            if(i != start) {
                dfs(locations, i,finish,fuel - Math.abs(locations[start] - locations[i]));
            }
        }
    }

    public static void main(String[] args) {
//        int[] locations = {2,3,6,8,4};
//        int start = 1, finish = 3, fuel = 5;

        int[] locations = {1,2,3};
        int start = 0, finish = 2, fuel = 40;

        System.out.println(new Solution1575().countRoutes(locations,start,finish,fuel));
    }
}

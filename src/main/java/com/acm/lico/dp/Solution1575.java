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
 * @author 谢小平
 * @date 2021/12/23
 */
public class Solution1575 {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {

    }
}

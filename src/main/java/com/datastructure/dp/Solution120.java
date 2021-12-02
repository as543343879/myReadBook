package com.datastructure.dp;

import java.util.Arrays;
import java.util.List;

/**
 * Solution120 class
 *
 * @author 谢小平
 * @date 2021/12/2
 */
/**
 * https://leetcode-cn.com/problems/triangle/
 *  三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(n^3)
 空间复杂度
 O(n^2)
 2 定位问题
根据问题类型，确定采用何种算法思维。
 dp 状态转移方程
S(i,j) 表示 到i+1列的 各个最短路径
    i=0 S(i,j)=triangle[0][0]
    S(i,j) = triangle(i,j) + min( S(i-1,j) +  S(i-1,j-1) );
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情
 执行用时： 3 ms , 在所有 Java 提交中击败了 81.85% 的用户 内存消耗： 38.1 MB ,
 在所有 Java 提交中击败了 68.66% 的用户 通过测试用例： 44 / 44
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i + 1; j ++) {
                if(j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
                } else if(j == i) {
                    dp[i][j] =triangle.get(i).get(j)+ dp[i-1][j-1];
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j],  dp[i-1][j-1]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        n --;
        for(int i = 0; i <= n; i ++) {
            min = min > dp[n][i] ? dp[n][i] : min;
        }
        return min;
    }
    public static void main(String[] args) {
        int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
    }
}

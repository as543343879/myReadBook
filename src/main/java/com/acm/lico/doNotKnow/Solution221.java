package com.acm.lico.doNotKnow;

/**
 * Solution221 class
 * https://leetcode.cn/problems/maximal-square/
 *221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 *12321
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","1","1","1"]]
 * 输出：4
 * 示例 2：
 *
 *
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 * @author 谢小平
 * @date 2022/8/23
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 思路已：
 时间复杂度
 O(N*M)
 空间复杂度
 O(N*M)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
 思路一：
 动态规划：
    dp[i][j] 表示已i,j 为右下角的正方形。
    dp[i][j] = min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j] ) + 1;
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
 执行用时： 6 ms , 在所有 Java 提交中击败了 78.95% 的用户
 内存消耗： 52.2 MB , 在所有 Java 提交中击败了 94.91% 的用户
 通过测试用例： 77 / 77
 */

public class Solution221 {

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int y = matrix.length;
        int x = matrix[0].length;
        int[][] dp = new int[y][x];
        for(int i = 0; i < y; i ++) {
            for(int j =0; j < x; j ++) {
                if(matrix[i][j] == '1') {
                    if(i == 0 || j == 0) {
                        dp[i][j] =1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j] ), dp[i][j-1]) + 1;

                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }

}

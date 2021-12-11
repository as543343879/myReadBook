package com.acm.lico.dp;

/**
 * Solution64 class
 *给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * @author 谢小平
 * @date 2021/11/22
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
    O(line*width) 一次遍历
 空间复杂度
    O(line*width) 一次遍历
 2 定位问题
根据问题类型，确定采用何种算法思维。
    dp
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注 执行用时：
 3 ms , 在所有 Java 提交中击败了 41.33% 的用户
 内存消耗： 40.8 MB , 在所有 Java 提交中击败了 92.24% 的用户 通过测试用例： 61 / 61
 */
public class Solution64 {
    /**
     * S(i,j) = min(S(i-1,j) ,S(i,j-1) ) + grid[i][j]
     * S(0,0) = 1;
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int line = grid.length;
        int width = grid[0].length;
        int [][] dp = new int [line][width];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < line; i ++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < width; i ++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < line; i ++) {
            for(int j = 1; j < width; j ++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[line-1][width-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new Solution64().minPathSum(grid));
    }
}

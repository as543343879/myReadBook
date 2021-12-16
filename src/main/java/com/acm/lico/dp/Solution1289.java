package com.acm.lico.dp;

/**
 * Solution1289 class
 * https://leetcode-cn.com/problems/minimum-falling-path-sum-ii/
 *1289. 下降路径最小和 II
 * 给你一个整数方阵 arr ，定义「非零偏移下降路径」为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 *
 * 请你返回非零偏移下降路径数字和的最小值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 *
 *
 * 作者：宫水三叶
 * 链接：https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/r8oh2h/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author 谢小平
 * @date 2021/12/13
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
 S(i,j) i行号
 i = 0 S(i,j)
 i != 0 S(i,j) = grid(i,j) + min(S(i-1,j!=j) );

    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
public class Solution1289 {
    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 52 ms , 在所有 Java 提交中击败了 30.02% 的用户
     * 内存消耗： 45.2 MB , 在所有 Java 提交中击败了 38.49% 的用户
     * 通过测试用例： 16 / 16
     * @param grid
     * @return
     */
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][]dp = new int[n][m];

        System.arraycopy(grid,0,dp,0,1);
//
//        for(int i = 0;i < m; i ++ ) {
//            dp[0][i] = grid[0][i];
//        }

        for(int i = 1; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                int min = Integer.MAX_VALUE ;
                for(int k = 0; k < m; k ++) {
                    if(k!=j) {
                        min = min > dp[i-1][k] ? dp[i-1][k] : min;
                    }
                }
                dp[i][j] =  grid[i][j]  + min;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i ++) {
            min = min  > dp[n-1][i] ? dp[n-1][i] :min;
        }
        return min;

    }



}

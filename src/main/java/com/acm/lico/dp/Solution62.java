package com.acm.lico.dp;

/**
 * Solution63 class
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *https://leetcode-cn.com/problems/unique-paths/
 *
 * @author 格林
 * @date 2021-07-02
 */
public class Solution62 {
    private int count;

    /**
     *  时间超限，转换为 动态规划。 或者m。
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
         dfs(m,n,1,1);
        return count;
    }

    private void dfs(int h, int w, int left, int down) {
        if(left == w && down == h){
            count++;
            return;
        }
        if(left < w) {
            dfs(h,w,left + 1,down);
        }
        if( down < h) {
            dfs(h,w,left,down + 1);
        }
    }


    public int uniquePaths2(int m, int n) {
       int [][] f = new int[m][n];
       for(int i = 0; i < m; i ++) {
           f[i][0] = 1;
       }
       for(int j = 0; j < n; j ++) {
           f[0][j] = 1;
       }
       for(int i = 1; i < m; i ++) {
           for(int j = 1; j < n; j ++ ) {
               f[i][j] = f[i - 1][j] + f[i][j-1];
           }
       }
       return f[m -1][n - 1];
    }

}

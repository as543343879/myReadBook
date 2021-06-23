package com.acm.lico;

/**
 * Solution200 class
 *
 * @author 格林
 * @date 2021-06-22
 */
public class Solution200 {
    public int numIslands(char[][] grid) {
        int width = grid[0].length;
        int higth = grid.length;
        int count = 0;
        for(int i = 0; i < higth; i ++) {
            for(int j = 0; j < width; j ++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i,j);
                    count ++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] ='0';
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
    }
}

package com.acm.lico;

/**
 * Solution79 class
 *给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 1 复杂度分析
 * 2 深度便利
 *
 * 对 第一版 方向代码重构 代码精简 耗时好烦了一倍
 * @author 谢小平
 * @date 2021/7/21
 */
public class Solution79V2 {
    boolean[][] bools;
    int row,col;
    int[][] direction = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        bools = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == word.charAt(0)) {
                    bools[i][j] = true;
                     if(dfs(board,i,j,1, word)) {
                         return true;
                     } else {
                         bools[i][j] = false;
                     }
                }
            }
        }
        return  false;
    }

    private boolean dfs(char[][] board,int y, int x, int len, final String world) {
        if(len == world.length() ) {
            return true;
        }
        for(int[] d : direction) {
            int newX = x + d[0];
            int newY = y + d[1];
            if(newX >= 0 && newY>=0  && newY < row  && newX < col && !bools[newY][newX] && board[newY][newX] == world.charAt(len)) {
                bools[newY][newX] = true;
                if(dfs(board,newY,newX,len + 1, world)) {
                    return true;
                } else {
                    bools[newY][newX] = false;
                }
            }
        }
        return false;
    }

}

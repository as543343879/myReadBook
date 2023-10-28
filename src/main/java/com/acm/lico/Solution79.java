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
 * @author 谢小平
 * @date 2021/7/21
 */
public class Solution79 {

    public static void main(String[] args) {
        char [][] ts = {{'a','a'},{'A','A'}};
        System.out.println(new Solution79().existNew20(ts, "aaa"));
    }
    public boolean existNew20(char[][] board, String word) {
        if(word == null || board == null || word.length() == 0 || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if(board.length * board[0].length < word.length()) {
            return false;
        }
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == word.charAt(0)) {
                    char temp =  board[i][j];
                    board[i][j] = '#';
                    boolean dfsRes = dfs(board, word, i, j, 1);
                    if(dfsRes) {
                        return true;
                    } else {
                        board[i][j] = temp;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int rows, int colums, int wordIndex) {
        if(wordIndex == word.length()) {
            return true;
        }
        int[][] indexs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i = 0; i < indexs.length; i ++) {
            int x = rows + indexs[i][0];
            int y = colums + indexs[i][1];
            if( x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == word.charAt(wordIndex)) {
                char temp = board[x][y];
                board[x][y] = '#';
                boolean tempRes = dfs(board, word,x, y, wordIndex + 1);
                board[x][y] = temp;
                if(tempRes) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean[][] bools;
    int row,col;
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
        int t = y + 1;
        if(t < row && !bools[t][x] && board[t][x] == world.charAt(len) ) {
            bools[t][x] = true;
            if(dfs(board,t,x,len + 1,world)) {
                return true;
            } else {
                bools[t][x] = false;
            }
        }
        t = y - 1;
        if(t >= 0 && !bools[t][x] && board[t][x] == world.charAt(len) ) {
            bools[t][x] = true;
            if(dfs(board,t,x,len + 1,world)) {
                return true;
            } else {
                bools[t][x] = false;
            }
        }

        t = x + 1;
        if(t < col && !bools[y][t] && board[y][t] == world.charAt(len) ) {
            bools[y][t] = true;
            if(dfs(board,y,t,len + 1,world)) {
                return true;
            } else {
                bools[y][t] = false;
            }
        }

        t = x - 1;
        if(t >= 0 && !bools[y][t] && board[y][t] == world.charAt(len) ) {
            bools[y][t] = true;
            if(dfs(board,y,t,len + 1,world)) {
                return true;
            } else {
                bools[y][t] = false;
            }
        }
        return  false;
    }

}

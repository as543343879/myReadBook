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
    boolean isSucess = false;
    public boolean exist(char[][] board, String word) {
        boolean[][] bools = new boolean[board.length][board[0].length];
        dfs(0, 0,board,bools,word,new StringBuilder());
        return isSucess;
    }

    private void dfs(int startX, int startY,char[][] board, boolean[][] bools ,String word, StringBuilder haveStr) {
        int y = board[0].length;
        int x = board.length;
        if(haveStr.length() == word.length()) {
            isSucess = true;
            return ;
        }
        int t = startX + 1;
        if(t < x && !bools[t][startY]) {
            if(board[t][startY] == word.charAt(haveStr.length())) {
                haveStr.append(board[t][startY]);
                bools[t][startY] = true;
            } else {
                haveStr = new StringBuilder() ;
            }
            dfs(t,startY,board,bools,word,haveStr);

        }
        t = startX - 1;
        if(t >= 0 && !bools[t][startY]) {
            if(board[t][startY] == word.charAt(haveStr.length())) {
                haveStr.append(board[t][startY]);
                bools[t][startY] = true;
            } else {
                haveStr = new StringBuilder() ;
            }
            dfs(t,startY,board,bools,word,haveStr);

        }
        t = startY + 1;
        if( t < y && !bools[startX][t]) {
            if(board[startX][t] == word.charAt(haveStr.length())) {
                haveStr.append(board[startX][t]);
                bools[startX][t] = true;
            } else {
                haveStr = new StringBuilder() ;
            }
            dfs(startX,t,board,bools,word,haveStr);

        }
        t = startY - 1;
        if( t >= 0 && !bools[startX][t]) {
            if(board[startX][t] == word.charAt(haveStr.length())) {
                haveStr.append(board[startX][t]);
                bools[startX][t] = true;
            } else {
                haveStr = new StringBuilder() ;
            }
            dfs(startX,t,board,bools,word,haveStr);

        }

    }
}

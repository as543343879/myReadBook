package com.acm.lico;

/**
 * Solution36 class
 *36. 有效的数独
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * @author 格林
 * @date 2021-06-29
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        // 行
        int[][] rows = new int[9][10];
        // 列
        int[][] cols = new int[9][10];
        // box
        int[][] boxs = new int[9][10];
        for(int i = 0; i < 9; i ++) {
            for(int j = 0; j < 9; j ++) {
                if(board[i][j] == '.') continue;
                int t = board[i][j]-'0';
                if(rows[i][t] !=0) {
                    return false;
                } else {
                    rows[i][t] = 1;
                }

                if(cols[j][t] != 0) {
                    return  false;
                } else {
                    cols[j][t] = 1;
                }

                int box = i / 3 + j / 3 * 3;
//                int index = i % 3 * 3 + j % 3 ;
                if(boxs[box][t] != 0) {
                    return  false;
                } else {
                    boxs[box][t] = 1;
                }

            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        // 行
        int[][] rows = new int[9][10];
        // 列
        int[][] cols = new int[9][10];
        // box
        int[][] boxs = new int[9][10];
        for(int i = 0; i < 9; i ++) {
            for(int j = 0; j < 9; j ++) {
                if(board[i][j] == '.') continue;
                int t = board[i][j]-'0';
                if(rows[i][t] !=0 || cols[j][t] != 0) {
                    return false;
                }
                int box = i / 3 +  j / 3 * 3;
                if(boxs[box][t] != 0) {
                    return  false;
                }
                rows[i][t] = 1;
                boxs[box][t] = 1;
                cols[j][t] = 1;

            }
        }
        return true;
    }
}

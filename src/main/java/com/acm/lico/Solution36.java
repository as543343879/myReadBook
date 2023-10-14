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

    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度 O(N*N) N=9
     空间复杂度 O(3N*N)
     O(1) 一个常量下完成
     O(n) 一次遍历
     O(logn) 折半查询
     O(n^2) 两重嵌套循环查询
     2 定位问题
     根据问题类型，确定采用何种算法思维。
     例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
     思路：
     1. 建立一个 3个 9长度的字典，记录数字是否第一次出现
     2. 二层循环便利 这9个字典。
     3. 中间9格， 利用  i / 3  * 3 + j / 3  来定位下标。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:2 ms,击败了40.64% 的Java用户
     内存消耗:42.1 MB,击败了43.29% 的Java用户
     */
    public boolean isValidSudokuNew20(char[][] board) {
        if(board == null) {
            return false;
        }
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] checks = new boolean[9][9];
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++ ) {
                if(board[i][j] != '.') {
                    int t = board[i][j] -'0' - 1;
                    if(rows[i][t]) {
                        return false;
                    } else {
                        rows[i][t] = true;
                    }

                    if(cols[j][t]) {
                        return false;
                    } else {
                        cols[j][t] = true;
                    }
                    int x =  i  / 3  * 3 + j / 3;
                    if(checks[x][t]) {
                        return false;
                    } else {
                        checks[x][t] = true;
                    }
                }
            }
        }

        return true;
    }

    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度 O(N*N) N=9
     空间复杂度 O(3N*N)
     O(1) 一个常量下完成
     O(n) 一次遍历
     O(logn) 折半查询
     O(n^2) 两重嵌套循环查询
     2 定位问题
     根据问题类型，确定采用何种算法思维。
     例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
     思路：
     1. 建立一个 3个 9长度的字典，记录数字是否第一次出现
     2. 二层循环便利 这9个字典。
     3. 中间9格， 利用  i / 3  * 3 + j / 3  来定位下标。
     3 数据操作分析 , 用二进制 来表示 三个值 111
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     解答成功:
     执行耗时:1 ms,击败了99.94% 的Java用户
     内存消耗:42.1 MB,击败了32.76% 的Java用户
     */
    final int byte1 = 0b1;
    final int byte2 = 0b10;
    final int byte3 = 0b100;
    public boolean isValidSudokuNew21(char[][] board) {
        if(board == null) {
            return false;
        }
        int[][] checks = new int[9][9];
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++ ) {
                if(board[i][j] != '.') {
                    int t = board[i][j] -'0' - 1;
                    if((checks[i][t] & byte1) == 1) {
                        return false;
                    } else {
                        checks[i][t] = checks[i][t] | byte1;
                    }

                    if((checks[j][t] & byte2) == 2) {
                        return false;
                    } else {
                        checks[j][t] = checks[j][t] | byte2 ;
                    }
                    int x =  i  / 3  * 3 + j / 3;
                    if((checks[x][t] & byte3) == 4 ) {
                        return false;
                    } else {
                        checks[x][t] = checks[x][t] | byte3;
                    }
                }
            }
        }

        return true;
    }
}

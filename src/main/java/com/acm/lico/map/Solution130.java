package com.acm.lico.map;

/**
 被围绕的区域:130
 2023-11-06 14:56:29
 //给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
 //。
 //
 //
 //
 //
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
 //"X","X"]]
 //输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 //解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
 //会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 //
 //
 // 示例 2：
 //
 //
 //输入：board = [["X"]]
 //输出：[["X"]]
 //
 //
 //
 //
 // 提示：
 //
 //
 // m == board.length
 // n == board[i].length
 // 1 <= m, n <= 200
 // board[i][j] 为 'X' 或 'O'
 //
 //
 // Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1048 👎 0

 **/

import java.util.Arrays;

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
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 数组下标弄反了
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 1 ms , 在所有 Java 提交中击败了 99.93% 的用户
 内存消耗： 43.6 MB , 在所有 Java 提交中击败了 24.56% 的用户
 通过测试用例： 58 / 58
 */
public class Solution130 {

    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N*M)
     空间复杂度  O(N*M)
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
     思路： 深度优先便利。
     1. 最终结果是O 的 一定是 4边是O的，然后往4个方向发展有关联的。
     2. 先对 4边进行深度搜索，O的元素标记成 'A'。
     3. 然后便利所有元素， 'A' 改成 'O' 。 'O' 改成 'X'。

     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:1 ms,击败了99.91% 的Java用户
     内存消耗:42.4 MB,击败了97.61% 的Java用户
     */
    public void solveNew20(char[][] board) {
        if(board == null || board.length <= 1  || board[0].length <= 1 ) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < m; i ++) {
            dfs2(board, 0, i);
            dfs2(board, n - 1, i);
        }

        for(int i = 1; i < n - 1; i ++ ) {
            dfs2(board, i, 0);
            dfs2(board, i, m - 1);
        }

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs2(char[][] boards, int x, int y ) {
        if(x >= 0 && x < boards.length && y >= 0 && y < boards[0].length && boards[x][y] == 'O') {
            boards[x][y] = 'A';
            int[] directs = {-1, 0 , 1, 0, -1};
            for(int i = 0; i < directs.length - 1; i ++) {
                dfs2(boards, x + directs[i], y + directs[i + 1]);
            }
        }
    }

    public void solve(char[][] board) {
        int high_size = board.length;
        if (high_size <= 1){
            return;
        }
        int width_size = board[0].length;
        if (width_size <= 1) {
            return ;
        }


        for(int i = 0; i < width_size ; i ++ ) {
            int high = 0;
            dfs(board,high,i);
            high = high_size -1;
            dfs(board,high, i);

        }

        for(int i = 0; i < high_size ; i ++) {
            dfs(board,i,0);
            dfs(board,i, width_size - 1);
        }



        for(int i = 0; i < high_size ; i ++) {
            for (int j = 0; j < width_size ; j ++) {
                if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

            }
        }



    }

    public void dfs(char[][] board, int y, int x ) {
        int high_size = board.length ;
        int width_size = board[0].length ;
       if (x < 0|| y < 0 || x >= width_size || y >= high_size || board[y][x] != 'O') {
           return;
       }

        board[y][x] = 'A';
        dfs(board,y, x+1);
        dfs(board,y, x-1);
        dfs(board,y-1, x);
        dfs(board,y+1, x );

    }
//    [['O','O','O'],['O','O','O'],['O','O','O']]
//    输出：
//            [['O','O','O'],['O','X','O'],['O','O','O']]
//    预期结果：
//            [['O','O','O'],['O','O','O'],['O','O','O']]
    public static void main(String[] args) {
//        char[][] t = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        char[][] t =   {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        new Solution130().solve(t);
        for (char[] i : t){
            System.out.println(Arrays.toString(i));
        }
    }
}

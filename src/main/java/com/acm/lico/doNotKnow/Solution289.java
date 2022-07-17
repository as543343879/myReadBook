package com.acm.lico.doNotKnow;

/**
 * Solution289 class
 * https://leetcode.cn/problems/game-of-life/
 *
 *289. 生命游戏
 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：board =
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]]
 * 输出：[
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]]
 * 示例 2：
 *
 *
 * 输入：board = [[1,1],[1,0]]
 * 输出：[[1,1],[1,1]]
 *
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] 为 0 或 1
 *
 *
 * 进阶：
 *
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 * @author 谢小平
 * @date 2022/7/15
 */
public class Solution289 {
    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.3 MB , 在所有 Java 提交中击败了 5.04% 的用户
     * 通过测试用例： 22 / 22
     *
     * @param board
     */
    /**
     1 复杂度分析
    估算问题中复杂度的上限和下限
     时间复杂度
     O(N*M)
     空间复杂度
     O(N*M)
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
     5 执行结果
     */
    public void gameOfLife(int[][] board) {
        int y = board.length;
        int x = board[0].length;
        int[][] newBoard = new int[y][x];
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < x; j ++) {
                int count = getIsLive(i,j,board);
                if(board[i][j] == 1) {
                    if (count < 2 || count > 3 ) {
                        newBoard[i][j] = 0;
                    } else{
                        newBoard[i][j] = 1;
                    }
                } else {
                    if(count == 3) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }

            }
        }
        for(int i = 0; i < board.length; i ++) {
            for (int j = 0; j < x; j++) {
                board[i][j] = newBoard[i][j];
            }
        }

    }

    /**
     *
     *  * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
     *  * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     *  * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
     *  * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
     *
     * @param y
     * @param x
     * @param board
     * @return
     */
    public int getIsLive(int y, int x, int[][] board) {
        int [][] index = new int[][] {{-1,1},{-1,0},{-1,-1},{1,1},{1,0},{1,-1},{0,1},{0,-1}};
        int n= board.length;
        int m = board[0].length;
        int count = 0 ;
        for(int [] i : index) {
            int yy = y + i[0];
            int xx = x + i[1];
            if (xx >= 0 && yy >= 0 & xx < m && yy < n) {
                if (board[yy][xx] == 1) {
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] testData = new int[][] {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        new Solution289().gameOfLife(testData);
    }
}

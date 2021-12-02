package com.datastructure.dp;

/**
 * Solution63 class
 *63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 作者：宫水三叶
 * 链接：https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rt1hg6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author 谢小平
 * @date 2021/11/18
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
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 5.13% 的用户
 通过测试用例： 41 / 41
 */
public class Solution63 {
    /**
     * S(i,j) 为到达位置(i,j)的不同路径数量。
     * S(0,0) = 1
     *
     * obstacleGrid[i,j] = 0
     * S(i,j) = S(i-1,j) + S(i,j-1)
     * obstacleGrid[i,j] = 1
     * S(i,j) = 0
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int minValue = Integer.MIN_VALUE;


        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        int high = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        if( obstacleGrid[0][0] == 1 || obstacleGrid[high-1][width-1] == 1) {
            return 0;
        }

        if( obstacleGrid[0][0] == 1 && (high == 1 || width == 1) ) {
            return 0;
        }
         boolean flag = false;
        for(int i = 0; i < high; i ++) {
            if(flag) {
                dp[i][0] = minValue;
            } else {
                if(obstacleGrid[i][0] == 1) {
                    dp[i][0] = minValue;
                    flag = true;
                } else {
                    dp[i][0] = 1;
                }
            }
        }
        flag = false;
        for(int j = 0; j < width; j ++) {
            if(flag) {
                dp[0][j] = minValue;
            } else {
                if(obstacleGrid[0][j] == 1) {
                    dp[0][j] = minValue;
                    flag = true;
                } else {
                    dp[0][j] = 1;
                }
            }
        }
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for(int i = 1; i < high; i ++) {
            for(int j = 1 ; j < width; j ++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = minValue;
                    continue;
                } else {
//                    if(i >= 1 && j >= 1) {

                        if(dp[i-1][j] == minValue && dp[i][j-1] == minValue ) {
                            dp[i][j] = minValue;
                        } else if(dp[i-1][j] == minValue )  {
                            dp[i][j] = dp[i][j-1];
                        } else if(dp[i][j-1] == minValue) {
                            dp[i][j ]= dp[i-1][j];
                        } else {
                            dp[i][j] = dp[i-1][j] + dp[i][j-1];
                        }
//                    }
                }
            }
        }
        return  dp[high - 1][ width - 1] == minValue ? 0 :dp[high - 1][ width - 1] ;
    }

    public static void main(String[] args) {
        //[[0,1,0,0,0],
        // [1,0,0,0,0],
        // [0,0,0,0,0],
        // [0,0,0,0,0]]
        //11
        //00

//       int[][]  ints = {{0,1},{0,0}}; // {{0,0,0},{0,1,0},{0,0,0}};

//        int[][]  ints ={{0,0,0},{0,1,0},{0,0,0}};
//        int[][]  ints ={{0,0,0},{0,1,0},{0,0,0}};

        int[][]  ints ={{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println( new Solution63().uniquePathsWithObstacles(ints));
    }
}

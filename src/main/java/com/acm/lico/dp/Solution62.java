package com.acm.lico.dp; /**
 62 ,不同路径
 //一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 //
 // 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 //
 // 问总共有多少条不同的路径？
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：m = 3, n = 7
 //输出：28
 //
 // 示例 2：
 //
 //
 //输入：m = 3, n = 2
 //输出：3
 //解释：
 //从左上角开始，总共有 3 条路径可以到达右下角。
 //1. 向右 -> 向下 -> 向下
 //2. 向下 -> 向下 -> 向右
 //3. 向下 -> 向右 -> 向下
 //
 //
 // 示例 3：
 //
 //
 //输入：m = 7, n = 3
 //输出：28
 //
 //
 // 示例 4：
 //
 //
 //输入：m = 3, n = 3
 //输出：6
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= m, n <= 100
 // 题目数据保证答案小于等于 2 * 10⁹
 //
 //
 // Related Topics 数学 动态规划 组合数学 👍 1719 👎 0

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
 自己思路：
 时间复杂度 O(N * M)
 空间复杂度 O(N * M)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 动态规划
 dp[i][j] 表示 到达 i,j 下标有多少种方法，
 动态转移方程： dp[i][j] = dp[i-1][j] + dp[i][j-1];
 dp边界：
 初始化为0。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:38.3 MB,击败了56.42% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution62 {

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
     思路： 动态规划 dp[i][j] 表示达到下标的路径次数。 = dp[i-1][j] + dp[i][j-1];
     1. dp[0][j] = 1; dp[i][0] = 1;

     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:38.1 MB,击败了57.99% 的Java用户
     */
    public int uniquePathsNew20(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i ++) {
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j ++) {
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0],1);
        for(int i = 0; i < m; i ++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


    private int count;

    /**
     *  时间超限，转换为 动态规划。 或者m。
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths3(int m, int n) {
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

    /**
     * 以前刷的动态规划
     * @param m
     * @param n
     * @return
     */
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
//leetcode submit region end(Prohibit modification and deletion)

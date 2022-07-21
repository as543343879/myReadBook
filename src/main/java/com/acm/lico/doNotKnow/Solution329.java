package com.acm.lico.doNotKnow;

/**
 * Solution329 class
 * https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/
 *329. 矩阵中的最长递增路径
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 * 示例 2：
 *
 *
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * 示例 3：
 *
 * 输入：matrix = [[1]]
 * 输出：1
 * @author 格林
 * @date 2022-07-21
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 N表示数组宽度， M 表述数组长度。
 时间复杂度
 O(N*M*N*M) 错了
 因为有缓存， 深度搜索时间复杂度 O(V + E) v 是节点数， e 是边数。
 空间复杂度
 O(N*M)
 O()
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
 深度搜索，用个一个缓存 缓存搜索过的结果

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
public class Solution329 {
    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 15 ms , 在所有 Java 提交中击败了 17.16% 的用户
     * 内存消耗： 41.6 MB , 在所有 Java 提交中击败了 54.91% 的用户
     * 通过测试用例： 138 / 138
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        int x = matrix[0].length;
        int [][] res = new int[matrix.length][x];
        int max = Integer.MIN_VALUE;
        for(int i =0; i < matrix.length; i ++) {
            for(int j = 0; j < x; j ++) {
                max = Math.max( max,dfs(matrix,i,j,res) );
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] res) {
        int[][] ways = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        if(res[i][j] != 0) {
            return res[i][j];
        }
        res[i][j] ++;
        for(int[] dirs: ways) {
            int y = dirs[0] + i;
            int x = dirs[1] + j;
            if(y < matrix.length && y >= 0 && x >=0 && x < matrix[0].length) {
                if(matrix[y][x] > matrix[i][j]) {
                    res[i][j] = Math.max(res[i][j], dfs(matrix,y,x,res) + 1);
                }
            }

        }
        return res[i][j];
    }

}

package com.acm.lico.dp;

/**
 * Solution931 class
 * https://leetcode-cn.com/problems/minimum-falling-path-sum/
 *931. 下降路径最小和
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 *
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * 作者：宫水三叶
 * 链接：https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/r85adr/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author 谢小平
 * @date 2021/12/11
 *
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(n) n是数组大小
 空间复杂度
 O(n) n 是数组大小
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。
 dp
 S(i,j) =
    i == 0 时 min(S(0,j))
    i != 0 时候 matrix(i,j) + min(S(i-1,j-1) ,S(i-1,j), S(i-1,j+1 )
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 4 ms , 在所有 Java 提交中击败了 80.90% 的用户
 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 93.69% 的用户 通过测试用例： 49 / 49
 */
public class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];

        for(int i = 0; i < m; i ++ ) {
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1; i < n; i ++) {
            for(int j = 0 ; j < m; j ++) {
                if(j == 0) {
                    dp[i][j] = matrix[i][j] + ( dp[i-1][j] > dp[i-1][j+1] ? dp[i-1][j+1] :  dp[i-1][j]);
                } else if(j == m - 1) {
                    dp[i][j] = matrix[i][j] +( dp[i-1][j-1] > dp[i-1][j] ?  dp[i-1][j] : dp[i-1][j-1]);
                } else {
                    dp[i][j] = matrix[i][j] +( dp[i-1][j-1] > dp[i-1][j] ? dp[i-1][j]  > dp[i-1][j+1] ? dp[i-1][j+1] :dp[i-1][j]  : dp[i-1][j-1]   > dp[i-1][j+1] ? dp[i-1][j+1]: dp[i-1][j-1])    ;
                }
//                System.out.print(dp[i][j] + " ");

            }
//            System.out.println();
        }
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < m; i ++ ) {
            res = res > dp[n-1][i] ?  dp[n-1][i]: res;
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] data = {{2,1,3},{6,5,4},{7,8,9}};
           System.out.println( new Solution931().minFallingPathSum(data));
    }
}

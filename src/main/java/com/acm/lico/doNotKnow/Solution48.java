package com.acm.lico.doNotKnow;
//https://leetcode.cn/problems/rotate-image/
// 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
//
//
// 示例 2：
//
//
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
//
//
//
// 提示：
//
//
// n == matrix.length == matrix[i].length
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000
//
//
//
//
// Related Topics 数组 数学 矩阵 👍 1407 👎 0

/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 O(N*N)
 空间复杂度
 O(1)
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
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:40 MB,击败了84.22% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
public  class Solution48 {
    public void rotate(int[][] matrix) {
        int iMax = matrix.length / 2;
        int jMax = (matrix.length + 1) / 2;
        int n = matrix.length;
        for(int i = 0; i < iMax; i ++) {
            for(int j = 0; j < jMax; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1] ;
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] =  temp;

            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

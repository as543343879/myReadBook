package com.acm.lico.stack; /**
 最大矩形:85
 2023-01-26 16:08:57
 //给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
 //,["1","0","0","1","0"]]
 //输出：6
 //解释：最大矩形如上图所示。
 //
 //
 // 示例 2：
 //
 //
 //输入：matrix = []
 //输出：0
 //
 //
 // 示例 3：
 //
 //
 //输入：matrix = [["0"]]
 //输出：0
 //
 //
 // 示例 4：
 //
 //
 //输入：matrix = [["1"]]
 //输出：1
 //
 //
 // 示例 5：
 //
 //
 //输入：matrix = [["0","0"]]
 //输出：0
 //
 //
 //
 //
 // 提示：
 //
 //
 // rows == matrix.length
 // cols == matrix[0].length
 // 1 <= row, cols <= 200
 // matrix[i][j] 为 '0' 或 '1'
 //
 //
 // Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1452 👎 0

 **/

import java.util.Arrays;
import java.util.LinkedList;

/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询

 暴力的方式：
 时间复杂度 O(N^2*M)
 空间复杂度O(N*M)


 思路二的方式
 时间复杂度 O(N*M)
 空间复杂度O(N*M)

 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 思路一 暴力求解：
 计算出连续的宽度是多少。 然后暴力高度乘以 宽度，算最大值。

 思路二： 单调栈
 使用单调栈，找到某个元素 左右两边 小于他的元素高度。  再乘以宽度。 就是这个柱子的最大面积

 思路三： 单调栈
 使用单调栈，找到某个元素 左两边 小于他的元素高度， 跟另外一个小于 这个元素的高度。  再乘以宽度。 就是这个柱子的最大面积

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 暴力的方式：
 解答成功:
 执行耗时:19 ms,击败了35.11% 的Java用户
 内存消耗:45.7 MB,击败了37.34% 的Java用户

 思路二：
 解答成功:
 执行耗时:12 ms,击败了60.96% 的Java用户
 内存消耗:44.8 MB,击败了82.74% 的Java用户

 思路三：
 解答成功:
 执行耗时:9 ms,击败了73.52% 的Java用户
 内存消耗:46.1 MB,击败了20.05% 的Java用户

 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution85 {

    public int maximalRectangle2(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] widths = new int[n][m];

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(matrix[i][j] == '1') {
                    widths[i][j] = j == 0 ? 1:( widths[i][j - 1] + 1);
                }
            }
        }
        int res = 0;
        for(int j = 0; j < m; j ++) {
            int[] lefts = new int[n];
            LinkedList<Integer> stack = new LinkedList<>();
            for(int i = 0; i < n; i ++ ) {
                while ( !stack.isEmpty() && widths[stack.peek()][j] >=  widths[i][j]) {
                    stack.pop();
                }
                lefts[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            stack.clear();
            int[] rights = new int[n];
            for(int i = n - 1; i >= 0; i --) {
                while (!stack.isEmpty() && widths[stack.peek()][j] >= widths[i][j]) {
                    stack.pop();
                }
                rights[i] = stack.isEmpty() ? n: stack.peek();
                stack.push(i);
            }

            for(int i = 0; i < n; i ++) {
                int height = rights[i] - lefts[i] - 1;
                res = Math.max(res , height * widths[i][j]);
            }


        }
        return res;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] widths = new int[n][m];

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(matrix[i][j] == '1') {
                    widths[i][j] = j == 0 ? 1:( widths[i][j - 1] + 1);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                int width = widths[i][j];
                int area = width;

                for(int k = i -1; k >= 0; k --) {
                    int height = i - k + 1;
                    width = Math.min(widths[k][j], width);
                    area = Math.max(area, height * width);
                }

                res = Math.max(res, area);
            }
        }
        return res;
    }

    public int maximalRectangle3(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] widths = new int[n][m];

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(matrix[i][j] == '1') {
                    widths[i][j] = j == 0 ? 1:( widths[i][j - 1] + 1);
                }
            }
        }
        int res = 0;
        for(int j = 0; j < m; j ++) {
            int[] lefts = new int[n];
            int[] rights = new int[n];
            Arrays.fill(rights,n);
            LinkedList<Integer> stack = new LinkedList<>();
            for(int i = 0; i < n; i ++ ) {
                while ( !stack.isEmpty() && widths[stack.peek()][j] >=  widths[i][j]) {
                    Integer popI = stack.pop();
                    rights[popI] = i;
                }
                lefts[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }


            for(int i = 0; i < n; i ++) {
                int height = rights[i] - lefts[i] - 1;
                res = Math.max(res , height * widths[i][j]);
            }


        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

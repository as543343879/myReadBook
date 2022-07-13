package com.acm.lico.doNotKnow;

/**
 * Solution240 class
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/
 *240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [
 * [1,4,7,11,15],
 * [2,5,10,12,19],
 * [8,9,11,16,22],
 * [9,13,14,17,24],
 * [18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 *
 * [[2,5],
 * [2,8],
 * [7,9],
 * [7,11],
 * [9,11]]
 * 7
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 谢小平
 * @date 2022/7/13
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 7 ms
     时间复杂度
        O(N*M)
     空间复杂度
        O(1)
 5 ms
 时间复杂度O(N+M)
 空间复杂度O(1)

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
 执行结果： 通过 显示详情 添加备注
 执行用时： 5 ms , 在所有 Java 提交中击败了 93.28% 的用户
 内存消耗： 47.3 MB , 在所有 Java 提交中击败了 45.18% 的用户
 通过测试用例： 129 / 129

 */

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int y = 0;
        int x = matrix[y].length - 1;
        while (x >= 0 && y < matrix.length) {
            if(matrix[y][x] == target) {
                return true;
            }

            if(matrix[y][x] > target) {
                x--;
            } else {
                y ++;
            }
        }
        return false;
    }

    /**
     *  执行结果： 通过 显示详情 添加备注
     *  执行用时： 8 ms , 在所有 Java 提交中击败了 13.87% 的用户
     *  内存消耗： 47.6 MB , 在所有 Java 提交中击败了 7.29% 的用户
     *  通过测试用例： 129 / 129
     *
     *  执行结果： 通过 显示详情 添加备注 执行用时： 7 ms , 在所有 Java 提交中击败了 18.86% 的用户 内存消耗： 47 MB , 在所有 Java 提交中击败了 90.11% 的用户 通过测试用例： 129 / 129
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int x = 0;
        int midlleX = 0;
        int left = 0, right = matrix[0].length ;
        while ( left <= right) {
            midlleX = (right + left) / 2;
            if((matrix[0][midlleX] <= target && midlleX == matrix[0].length - 1) || (matrix[0][midlleX] <= target && matrix[0][midlleX + 1] > target )) {
                break;
            }
            else if(matrix[0][midlleX] > target) {
                right = midlleX - 1;
            } else {
                left = midlleX + 1;
            }
        }
        if(matrix[0][midlleX] == target) {
            return true;
        }
        for(int i = 0; i < matrix.length; i ++  ) {
            if (matrix[i][midlleX] >= target) {
               if (matrix[i][midlleX] == target) {
                   return true;
               }
               for(int k = midlleX -1; k >= 0; k -- ) {
                   if(matrix[i][k] == target) {
                       return true;
                   } else if(matrix[i][k] < target) {
                       for(int j = i - 1; j < matrix.length; j ++ ) {
                           if(matrix[j][k] == target) {
                               return true;
                           } else if (matrix[j][k] > target) {
                               break;
                           }
                       }
                   }
               }
               break;
            }
        }
        return false;
    }
    public static void main(String[] args) {
       int[][] matrix = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

//        matrix = new int[][] {{-5}};


        System.out.println(new Solution240().searchMatrix(matrix,19));
    }
}

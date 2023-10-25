package com.acm.lico;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution73 class
 * 73. 矩阵置零
 *给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 方法二：使用两个标记变量
 * 思路和算法
 *
 * 我们可以用矩阵的第一行和第一列代替方法一中的两个标记数组，以达到 O(1)O(1) 的额外空间。但这样会导致原数组的第一行和第一列被修改，无法记录它们是否原本包含 00。因此我们需要额外使用两个标记变量分别记录第一行和第一列是否原本包含 00。
 *
 * 在实际代码中，我们首先预处理出两个标记变量，接着使用其他行与列去处理第一行与第一列，然后反过来使用第一行与第一列去更新其他行与列，最后使用两个标记变量更新第一行与第一列即可
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes/solution/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-07-06
 */
public class Solution73 {

    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度 O(N*M)
     空间复杂度 O(M) 0的个数
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
     1. 便利 一遍， 用两个set 分别记录行和列。
     2. 便利 第二篇， 对行和列
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:1 ms,击败了48.83% 的Java用户
     内存消耗:43.4 MB,击败了74.75% 的Java用户
     */
    public void setZeroesNew20(int[][] matrix) {
        if(matrix == null) {
            return ;
        }
        Set<Integer> cols = new HashSet<>();
        Set<Integer> rows = new HashSet<>();
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[0].length; j ++) {
                if(matrix[i][j] == 0) {
                    cols.add(j);
                    rows.add(i);
                }
            }
        }
        for(int t : rows) {
            for(int i = 0 ; i < matrix[0].length; i ++) {
                matrix[t][i] = 0;
            }
        }
        for(int t: cols) {
            for(int i = 0; i < matrix.length; i ++ ) {
                matrix[i][t] = 0;
            }
        }

    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> setLine = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[i].length; j ++) {
                if(matrix[i][j] == 0) {
                   setLine.add(i);
                   setY.add(j);
                }
            }
        }
        for(Integer t : setLine) {
            for(int j = 0; j < matrix[0].length; j ++) {
                matrix[t][j] = 0;
            }
        }
        for(Integer t : setY) {
            for(int j = 0; j < matrix.length; j ++) {
                matrix[j][t] = 0;
            }
        }
    }
}

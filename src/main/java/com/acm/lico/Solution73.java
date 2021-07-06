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

package com.acm.lico;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution class
 *54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 * @author 谢小平
 * @date 2021/7/1
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int totalNum = matrix.length * matrix[0].length;

        int index = 0;
        // 1 表示 右 2 表示下 3 表示左 4 表示 上
        int direction = 1;
        int width = matrix[0].length;
        int heigth = matrix.length;
        int i = 0, j = 0;
        while (list.size() < totalNum) {
            int count = 0;
            while (count < width && list.size() < totalNum) {
                list.add(matrix[i][j++] );
                count ++;
            }
            heigth--;
            count = 0;
            j--;
            i++;
            while (count < heigth && list.size() < totalNum) {
                list.add(matrix[i++][j]);
                count++;
            }
            width--;
            i --;
            j--;
            count = 0;
            while (count < width&& list.size() < totalNum) {
                list.add(matrix[i][j--]);
                count++;
            }
            heigth--;
            j++;
            count = 0;
            i--;
            while (count < heigth && list.size() < totalNum) {
                list.add(matrix[i--][j]);
                count++;
            }
            i++;
            width--;
            j++;
        }
        return list;
    }
    
    public static void main(String[] args) {
        int[][] map = {{1,2,3,4},
                       {5,6,7,8},
                       {9,10,11,12}};
        // [1,2,3,4,8,12,11,10,9,5,6,7]
       System.out.println(Arrays.toString(new Solution54().spiralOrder(map).toArray()));
    }
//    [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
}

package com.acm.lico; /**
 54 ,螺旋矩阵
 //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]]
 //输出：[1,2,3,6,9,8,7,4,5]
 //
 //
 // 示例 2：
 //
 //
 //输入：matrix = [
 [1,2,3,4],
 [5,6,7,8],
 [9,10,11,12]]
 //输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 //
 //
 //
 //
 // 提示：
 //
 //
 // m == matrix.length
 // n == matrix[i].length
 // 1 <= m, n <= 10
 // -100 <= matrix[i][j] <= 100
 //
 //
 // Related Topics 数组 矩阵 模拟 👍 1337 👎 0

 **/

import com.acm.lico.Solution54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
 时间复杂度 O(N)
 空间复杂度 O(1)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 [1,2  ,3 ,4],
 [5,6  ,7 ,8],
 [9,10 ,11,12]]
 定义一个方向数组，{{0，1}， {-1，0}， {0，-1},{1, 0}},当 下标出了范围，跳出循环。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:39.5 MB,击败了70.70% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0) {
            return null;
        }
        int[][] dirct = {{0,1},{1,0}, {0,-1},{-1, 0}};
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        int allCount = n * m;
        List<Integer> res = new ArrayList<>(allCount);
        int MIN = 101;
        int i = 0, j =-1;
        while (count  < allCount ) {
            for(int[] t: dirct) {
                while (true) {
                    i += t[0];
                    j += t[1];
                    if(i  < 0 ||  i >= n   || j  < 0 || j  >= m ||matrix[i][j] == MIN ) {
                        i -= t[0];
                        j -= t[1];
                        break;
                    }
                    count++;
                    res.add(matrix[i][j]);
                    matrix[i][j] = MIN;
                }
            }

        }
        return res;
    }


    public List<Integer> spiralOrder2(int[][] matrix) {
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
//        int[][] map = {{1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12}};

        int[][] map = {{1,2,3},{4,5,6},{7,8,9}};
        // [1,2,3,4,8,12,11,10,9,5,6,7]
        System.out.println(Arrays.toString(new Solution54().spiralOrderNew20(map).toArray()));
    }
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N *M)
     空间复杂度 O(1)
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
     1. i，j 分别是 matrix 下标， 走过的地方赋值 -101。
     2. 先往有右边走， matrix[i][j++]
     3. 然后往下走， matrix[i--][j]
     4. 然后往左边走， matrix[i][j--]
     5. 然后往上面走，matrix[i--][j]
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:39.6 MB,击败了22.90% 的Java用户
     */
    public List<Integer> spiralOrderNew21(int[][] matrix) {
        if(matrix == null) {
            return new ArrayList<>();
        }
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>(n * m);
        int i = 0, j = -1;
        int count = 0;
        int visit = -101;
        int[][] directs = {{0,1},{1,0}, {0,-1},{-1, 0}};
        while (res.size() < n * m) {
            for(int[] direct: directs) {
                while (true) {
                    int tempI = i + direct[0];
                    int tempJ = j +  direct[1];
                    if(tempI >= 0 && tempI < n && tempJ >= 0 && tempJ < m && matrix[tempI][tempJ] != visit) {
                        i = tempI;
                        j = tempJ;
                        res.add(matrix[i][j]);
                        matrix[i][j] = visit;
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N *M)
     空间复杂度 O(1)
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
     1. i，j 分别是 matrix 下标， 走过的地方赋值 -101。
     2. 先往有右边走， matrix[i][j++]
     3. 然后往下走， matrix[i--][j]
     4. 然后往左边走， matrix[i][j--]
     5. 然后往上面走，matrix[i--][j]
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:39.5 MB,击败了42.64% 的Java用户
     */
    public List<Integer> spiralOrderNew20(int[][] matrix) {
        if(matrix == null) {
            return new ArrayList<>();
        }
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>(n * m);
        int i = 0, j = 0;
        int count = 0;
        int visit = -101;

        while (res.size() < n * m) {
            while (j < m  && matrix[i][j] != visit) {
                res.add(matrix[i][j]);
                matrix[i][j] = visit;
                j++;
            }
            j --;
            i++;

            while (i < n && j >=0 && matrix[i][j] != visit) {
                res.add(matrix[i][j]);
                matrix[i][j] = visit;
                i++;
            }
            i --;
            j --;

            while (j >= 0 &&  i >= 0&& matrix[i][j] != visit) {
                res.add(matrix[i][j]);
                matrix[i][j] = visit;
                j--;
            }
            j ++;
            i --;

            while (i >= 0 && j < m && matrix[i][j] != visit) {
                res.add(matrix[i][j]);
                matrix[i][j] = visit;
                i--;
            }
            i ++;
            j++;

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

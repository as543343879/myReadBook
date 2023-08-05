package com.acm.lico.array; /**
 59 ,螺旋矩阵 II
 //给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：n = 3
 //输出：
 [[1,2,3],
 [8,9,4],
 [7,6,5]]
 //
 //
 // 示例 2：
 //
 //
 //输入：n = 1
 //输出：[[1]]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= n <= 20
 //
 //
 // Related Topics 数组 矩阵 模拟 👍 953 👎 0

 **/
/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 自己思路：
 时间复杂度 O(N) N  是元素个数
 空间复杂度 O(1)
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询

 自己思路新：
 时间复杂度 O(n*n)
 空间复杂度 O(1)


 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 自己思路：
 控制方向， 控制 x,y 的坐标
 4 编码实现
 5 执行结果
 方向 direction
 自己思路：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:39.2 MB,击败了96.10% 的Java用户

 自己思路新：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:39.5 MB,击败了48.18% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution59 {

    public int[][] generateMatrix(int n) {
        if(n == 1) {
            return new int[][]{{1}};
        }
        int[][] res = new int[n][n];
        int x=0,y=-1;
        int allCount = n * n;
        int count = 1;
        int[][] dirct = {{0,1},{1,0},{0,-1},{-1, 0}};
        while (count <= allCount) {
            for(int[] t : dirct) {
                while (true) {
                    x += t[0];
                    y += t[1];
                    if(x < 0 || x >= n || y >= n || y < 0 || res[x][y] != 0) {
                        x -= t[0];
                        y -= t[1];
                        break;
                    }
                    res[x][y] = count++;
                }
            }
        }

        return res;
    }

    public int[][] generateMatrixOld(int n) {
        if(n == 1) {
            return new int[][]{{1}};
        }
        int x=0,y=0;

        int startDirection = 0;
        int startValue = 1;
        int[][] res = new int[n][n];
        while (startValue <= n*n){
            // 0 右，1 下， 2 左， 3 上
            if(startDirection == 0) {
                while (y  < n && res[x][y] == 0) {
                    res[x][y++] = startValue ++;
                }
                y --;
                x ++;

            }else if(startDirection == 1) {
                while (x  < n && res[x][y] == 0) {
                    res[x++][y] = startValue ++;
                }
                x --;
                y --;
            } else if(startDirection == 2) {
                while (y >= 0 && res[x][y] == 0) {
                    res[x][y--] = startValue ++;
                }
                y ++;
                x --;
            } else {
                while (x  >= 0 && res[x][y] == 0) {
                    res[x--][y] = startValue ++;
                }
                x ++;
                y++;
            }
            startDirection ++;
            startDirection %= 4;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

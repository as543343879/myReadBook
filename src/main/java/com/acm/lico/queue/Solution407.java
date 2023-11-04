package com.acm.lico.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 接雨水 II:407
 2023-11-04 21:21:21
 //给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 //
 //
 //
 // 示例 1:
 //
 //
 //
 //
 //输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 //输出: 4
 //解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
 //
 //
 // 示例 2:
 //
 //
 //
 //
 //输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 //输出: 10
 //
 //
 //
 //
 // 提示:
 //
 //
 // m == heightMap.length
 // n == heightMap[i].length
 // 1 <= m, n <= 200
 // 0 <= heightMap[i][j] <= 2 * 10⁴
 //
 //
 //
 //
 // Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 👍 699 👎 0

 **/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution407 {
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度 O(N*M*log(N*M)） offer 的时间复杂的是O(n) n长度是 N*M。
     空间复杂度 O(N*M)
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
     1. 从最外圈，最低点往内推，如果出现 最低的 高度，大于 heightMap 相邻的4个节点， 那这个节点 存水就是  min - heightMap[i][j] ;
     3 数据操作分析
     - 用最小堆， 存储 最外围的节点。
     - 用个 标志位 进行去除。
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:18 ms,击败了80.24% 的Java用户
     内存消耗:43.2 MB,击败了73.66% 的Java用户
     */
    public int trapRainWater(int[][] heightMap) {
        int res = 0;
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return res;
        }
        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][] visits = new boolean[n][m];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(i == 0 || j == 0 ||  i == n-1 || j == m - 1  ) {
                    priorityQueue.offer(new int[]{i * m + j, heightMap[i][j]});
                    visits[i][j] = true;
                }
            }
        }

        int[][] directs = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        while (!priorityQueue.isEmpty()) {
            int[] pollOne = priorityQueue.poll();
            int x = pollOne[0] / m;
            int y = pollOne[0] % m;
            for(int[] direct: directs) {
                int directX = x + direct[0];
                int directY = y + direct[1];
                if(directX >= 0 && directX < n && directY >= 0 && directY < m && !visits[directX][directY]) {
                    if (pollOne[1] > heightMap[directX][directY]) {
                        res += pollOne[1] - heightMap[directX][directY];
                    }
                    visits[directX][directY] = true;
                    priorityQueue.offer(new int[]{directX * m + directY, Math.max(pollOne[1] , heightMap[directX][directY] )});
                }

            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

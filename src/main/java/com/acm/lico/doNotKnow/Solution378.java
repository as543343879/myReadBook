package com.acm.lico.doNotKnow;

/**
 * Solution378 class
 * https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 *378. 有序矩阵中第 K 小的元素
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix =
 * [
 * [1,5,9],
 * [10,11,13],
 * [12,13,15]], k = 8
 *1 + 3 + 5
 *
 * all = 9
 * k大 = all-k 小 + 1=  第2大
 *
 * 输入：matrix = [
 * [ 1, 4, 7,11,15],
 * [ 2, 5,10,12,19],
 * [ 8, 9,11,16,22],
 * [ 9,13,14,17,24],
 * [18,21,23,26,30]], target = 8
 * all = 25
 * k大 = all-k小 + 1=  25 -8 + 1=18大
 * 1 + 3 + 5 + 7 + 9
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * 示例 2：
 *
 *
 *  * [1,5,9],
 *  * [2,11,13],
 *  * [3,13,15]], k = 8
 *
 *
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 *
 *
 * 提示：
 *
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
 * 1 <= k <= n2
 *
 *
 * 进阶：
 *
 * 你能否用一个恒定的内存(即 O(1) 内存复杂度)来解决这个问题?
 * 你能在 O(n) 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（ this paper ）很有趣。
 * @author 谢小平
 * @date 2022/7/28
 */

import java.util.PriorityQueue;

/**
 1 复杂度分析
估算问题中复杂度的上限和下限

 第二种思路
 时间复杂度
 O(N*N)
 错误。 堆的插入，弹出 都是logN
 K*logN

 空间复杂度
 O(N)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
思路：
 一种二分：
    可以利用左右，上下的有序性
 第二种
    归并排序
  利用左右的有序性。
  小顶堆，先进N个， 然后出一定比即将要进的要小的元素，然后进。这样边进边出。k-1 个后。 第k小的就在堆头
 根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 第二种：
 执行结果： 通过 显示详情 添加备注
 执行用时： 16 ms , 在所有 Java 提交中击败了 30.73% 的用户
 内存消耗： 47.8 MB , 在所有 Java 提交中击败了 5.02% 的用户
 通过测试用例： 86 / 86
 */
public class Solution378 {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int n = matrix.length;
        for(int i = 0; i < n; i ++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }
        int k1 = k-1;
        int n1 = n -1;
        for(int i = 0; i < k1; i ++) {
            int[] pollRes = minHeap.poll();
            if(pollRes[2] != n1) {
                minHeap.offer(new int[]{matrix[pollRes[1]][pollRes[2] + 1], pollRes[1],pollRes[2] + 1 });

            }
        }
        return minHeap.peek()[0];

    }

    public static void main(String[] args) {
        int[][] testData = new int[][] {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(new Solution378().kthSmallest(testData,8));
    }
    public int kthSmallest2(int[][] matrix, int k) {
        int y = matrix.length;
        int x = matrix[0].length;
        int xx = 1;
        int yy = 1;
        int count = 0;
        while (count < k) {
            count += (xx - 1) * (yy - 1) + 1;

        }
        return 0;
    }
}

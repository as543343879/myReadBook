package com.acm.lico.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 6348. 从数量最多的堆取走礼物
 * 给你一个整数数组 gifts ，表示各堆礼物的数量。每一秒，你需要执行以下操作：
 *
 * 选择礼物数量最多的那一堆。
 * 如果不止一堆都符合礼物数量最多，从中选择任一堆即可。
 * 选中的那一堆留下平方根数量的礼物（向下取整），取走其他的礼物。
 * 返回在 k 秒后剩下的礼物数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：gifts = [25,64,9,4,100], k = 4
 * 输出：29
 * 解释：
 * 按下述方式取走礼物：
 * - 在第一秒，选中最后一堆，剩下 10 个礼物。
 * - 接着第二秒选中第二堆礼物，剩下 8 个礼物。
 * - 然后选中第一堆礼物，剩下 5 个礼物。
 * - 最后，再次选中最后一堆礼物，剩下 3 个礼物。
 * 最后剩下的礼物数量分别是 [5,8,9,4,3] ，所以，剩下礼物的总数量是 29 。
 * 示例 2：
 *
 * 输入：gifts = [1,1,1,1], k = 4
 * 输出：4
 * 解释：
 * 在本例中，不管选中哪一堆礼物，都必须剩下 1 个礼物。
 * 也就是说，你无法获取任一堆中的礼物。
 * 所以，剩下礼物的总数量是 4 。
 *
 *
 * 提示：
 *
 * 1 <= gifts.length <= 103
 * 1 <= gifts[i] <= 109
 * 1 <= k <= 103
 */

/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 大顶堆
 采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
class Solution6348 {
    public static void main(String[] args) {
//        int[] testData =  {25,64,9,4,100};
        int[] testData =  {56,41,27,71,62,57,67,34,8,71,2,12,52,1,64,43,32,42,9,25,73,29,31};

        int count = 52;
        System.out.println(new Solution6348().pickGifts(testData, count));
    }
    public long pickGifts2(int[] gifts, int k) {

        gifts = Arrays.stream(gifts).boxed().
                sorted(((o1, o2) -> o2-o1)).mapToInt(Integer::intValue).toArray();
        int len = gifts.length;

        if(k > len) {
            int n = k / len;
            k = k % len;
            for(int i = 0; i < len; i ++ ) {

               for(int j =0; j < n; j ++) {
                   gifts[i] = (int) Math.sqrt(gifts[i]);
               }
            }
        }

        int startIndex = 0;
        for(int i = 0; i < k; i ++) {
            int maxIndex = i;
            if(startIndex > 0 ) {
                for(int j = 0; j  < startIndex ;  j ++) {
                    if(gifts[j] > gifts[maxIndex]) {
                        maxIndex = j;

                    }
                }
            }
            if(maxIndex == startIndex) {
                startIndex ++;
                if(startIndex == len) {
                    startIndex = 0;
                }
            }
            gifts[maxIndex] =  (int) Math.sqrt(gifts[maxIndex]);
        }
        long res = 0;
        for(int i = 0 ; i < len; i ++) {
            res += gifts[i];
        }
        return res;
    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        Arrays.stream(gifts).forEach(e->{
            priorityQueue.add(e);
        });

        for(int i = 0 ; i < k; i ++) {
            Integer maxE = priorityQueue.poll();
            maxE = (int)Math.sqrt(maxE);
            priorityQueue.offer(maxE);
        }
        long res = priorityQueue.stream().mapToLong(e ->  Long.valueOf(String.valueOf(e))).sum() ;

        return res;

    }
}
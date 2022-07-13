package com.acm.lico.doNotKnow;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution239 class
 * https://leetcode.cn/problems/sliding-window-maximum/
 *239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * @author 格林
 * @date 2022-07-12
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(NlogN)
 空间复杂度
 O(N) 元素个数
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
 */
public class Solution239 {
    /**
     * 执行结果：
     * 超出时间限制
     *  思路对的 但是可以优化， 就是栈顶元素一直可以存在
     * 显示详情
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(a -> -a));
        int k1 = k-1;
        int[] res = new int[nums.length -k1];
        int index = 0;
        for(int i = 0; i < k1; i ++) {
            queue.offer(nums[i]);
        }

        for(int i = k1; i < nums.length; i ++) {
            queue.offer(nums[i]);
            Integer iRes = queue.peek();
            res[index] = iRes;
            queue.remove(nums[index]);
            index++;
        }
        return res;
    }

    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 88 ms , 在所有 Java 提交中击败了 9.70% 的用户
     * 内存消耗： 55.2 MB , 在所有 Java 提交中击败了 69.26% 的用户
     * 通过测试用例： 51 / 51
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, ((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]));
//        int k1 = k-1;
        int[] res = new int[nums.length -k + 1];
        int index = 0;
        for(int i = 0; i < k; i ++) {
            queue.offer(new int[]{nums[i], i});
        }

        res[index++] = queue.peek()[0];
        for(int i = k; i < nums.length; i ++) {
            queue.offer(new int[]{nums[i], i});

            while (queue.peek()[1] <= i -k) {
                queue.poll();
            }
            res[index++] = queue.peek()[0];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] testData = new int[] {1,3,-1,-3,5,3,6,7};
        System.out.println(new Solution239().maxSlidingWindow(testData,3));
    }
}

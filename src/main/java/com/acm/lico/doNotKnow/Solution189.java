package com.acm.lico.doNotKnow;

import java.util.Arrays;

/**
 * Solution189 class
 *
 * https://leetcode.cn/problems/rotate-array/
 *
 *189. 轮转数组
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * @author 谢小平
 * @date 2022/6/28
 */

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
    O(n) 一次遍历
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
public class Solution189 {
    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 57.2 MB , 在所有 Java 提交中击败了 21.36% 的用户
     * 通过测试用例： 38 / 38
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int [] temp_nums = new int[k];
        System.arraycopy(nums, nums.length - k, temp_nums, 0, k);
        System.arraycopy(nums,0, nums, k, nums.length - k );
        System.arraycopy(temp_nums,0, nums,0,k);
        System.out.println(Arrays.toString(nums));
    }

    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
        System.out.println(gcd(11,30));
//        int [] res = {1,2,3,4,5,6,7};
//        new Solution189().rotate(res, 3);
    }
}

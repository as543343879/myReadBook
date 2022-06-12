package com.acm.lico.doNotKnow;

/**
 * Solution152 class
 * https://leetcode.cn/problems/maximum-product-subarray/
 *152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @author 格林
 * @date 2022-06-01
 */

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
    O(N)
 空间复杂度

    O(n) 一次遍历

 2 定位问题
根据问题类型，确定采用何种算法思维。
    动态规划
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注 执行用时： 2 ms ,
 在所有 Java 提交中击败了 66.55% 的用户 内存消耗： 41.7 MB ,
 在所有 Java 提交中击败了 19.73% 的用户 通过测试用例： 188
 / 188
 */
public class Solution152 {
    public static void main(String[] args) {
        int[] ar = {2,3,-2,4};
        System.out.println(new Solution152().maxProduct(ar));
    }

    public int maxProduct(int[] nums) {
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];
        dpMax[0] = dpMin[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i ++) {
            dpMax[i] = Math.max(dpMax[i-1] * nums[i], Math.max(nums[i], dpMin[i-1] * nums[i]));
            dpMin[i] = Math.min(dpMax[i-1] * nums[i], Math.min(nums[i], dpMin[i-1] * nums[i]));

            if (dpMax[i] > max){
                max = dpMax[i];
            }
        }
//        System.out.println(Arrays.toString(dpMax));
//
//        System.out.println(Arrays.toString(dpMin));
        return max;
    }
}

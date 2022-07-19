package com.acm.lico.doNotKnow;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Solution324 class
 * https://leetcode.cn/problems/wiggle-sort-ii/
 *324. 摆动排序 II
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 *
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 * @author 格林
 * @date 2022-07-19
 */
public class Solution324 {
    public void wiggleSort(int[] nums) {

    }
    /**
     * 思路错误
     * @param nums
     */
    public void wiggleSort2(int[] nums) {
        int[] copyNums = new int[nums.length];
        System.arraycopy(nums,0,copyNums,0,copyNums.length);
        Arrays.sort(copyNums);
        int left = 0;
        int n = nums.length;
        if(n == 1) {
            return ;
        }
        int right = n / 2  + 1;
        int index = 0;
        while (index < nums.length ) {
            nums[index ++] =  copyNums[left++];
            if(right < nums.length) {
                nums[index++] = copyNums[right++];
            }
//            nums[index ++] =  copyNums[left++];
        }

        if(nums[n - 1] == nums[n -2]) {
            int t = nums[n -2];
            nums[n-2] = nums[0];
            nums[0] = t;




        }

    }

    public static void main(String[] args) {
        int[] testData = new int[]{
                1,5,1,1,6,4};
        new Solution324().wiggleSort(testData);
    }
}

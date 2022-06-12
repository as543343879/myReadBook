package com.acm.lico.doNotKnow;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution class
 *https://leetcode.cn/problems/find-peak-element/
 * 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 *
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * @author 格林
 * @date 2022-06-12
 */

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 o(logn)
 空间复杂度
 o(1)
 2 定位问题
根据问题类型，确定采用何种算法思维。
 寻找最大值。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注 执行用时： 0 ms ,
 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 40.6 MB ,
 在所有 Java 提交中击败了 70.90% 的用户 通过测试用例： 63 / 63
 */

public class Solution162 {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int ans = -1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if(compare(nums,middle-1, middle)  < 0 && compare(nums, middle, middle + 1) >0 ) {
                ans = middle;
                break;
            }

            if(compare(nums,middle,middle +1) > 0) {
                right = middle -1;
            } else {
                left = middle + 1;
            }

        }

        return ans;

    }

    /**
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int compare(int[] nums, int start, int end ) {
        if(start == -1) {
            return -1;
        }
        if(end == nums.length) {
            return 1;
        }
       return nums[start] - nums[end];
    }


    /**
     *  思路完全错了
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {
        int[][] nums2 = new int[nums.length + 2][2];
        for(int i = 0; i < nums.length; i ++) {
            nums2[i+1][0] = nums[i];
            nums2[i+1][1] = i;
        }

        nums2[0][0] = Integer.MIN_VALUE;
        nums2[0][1] = -1;

        nums2[nums.length + 1][0] = Integer.MIN_VALUE;
        nums2[nums.length + 1][1] = nums.length;


        Arrays.sort(nums2, (int[] o1, int[] o2)->{return  - o2[0];});

//        Map<Integer, Integer> map = new HashMap<>(nums.length / 3 * 4 + 1);
//        map.put(-1,Integer.MIN_VALUE);
//        for(int i = 0; i < nums.length; i ++) {
//            map.put(nums[i],i);
//        }
//        map.put(nums.length,Integer.MIN_VALUE);
//
//
//        Arrays.sort(nums);
//
//        int s1 = map.get(Integer.MIN_VALUE)

        for(int i = 2; i < nums2.length; i ++ ) {
            if( (nums2[i][1] - nums2[i-1][1] ) + (nums2[i][1] = nums2[i-2][1]) ==0 ) {
               return nums2[i][1];
           }
        }
        return 0;
//        return findByMiddle(0,nums.length, nums);
    }

    public static void main(String[] args) {
        int[] testData = {1,2,1,3,5,6,4};
        System.out.println(new Solution162().findPeakElement(testData));
    }

//    private int findByMiddle(int start, int end, int[] nums) {
//        int minddle = (start + end) / 2;
//
//
//        return 0;
//    }
}

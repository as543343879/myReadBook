package com.acm.lico;

/**
 * Solution34 class
 *34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * @author 格林
 * @date 2021-06-29
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if(nums[mid] == target) {
                int begin = mid,end = mid;
                while (begin - 1 >= 0 && nums[begin - 1] == target) {
                    begin--;
                }
                while (end + 1 < nums.length && nums[end + 1] == target) {
                    end++;
                }
                return new int[]{begin,end};
            } else if(nums[mid] <  target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
}

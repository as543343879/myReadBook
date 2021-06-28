package com.acm.lico;

/**
 * Solution33 class
 *33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 *
 * @author 格林
 * @date 2021-06-28
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right + 1) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            // mid 在 左边线
            if(nums[0] < nums[mid]) {
                // [left,mid-1]
                if(nums[mid] > target && target >= nums[0]) {
                    right = mid - 1;
                // [mid + 1,right]
                } else {
                    left = mid + 1;
                }

             // mid 在 右边线
            } else {
                // [mid + 1,right]
                if(nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                // [left,mid - 1]
                } else {
                    right = mid - 1;

                }
            }
        }

        return -1;
    }
}

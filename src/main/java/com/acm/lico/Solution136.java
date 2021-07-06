package com.acm.lico;

import java.util.Arrays;

/**
 * Solution136 class
 *
 * @author 格林
 * @date 2021-07-04
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        Arrays.sort(nums);

        if(nums[0] != nums[1]) {
            return nums[0];
        }
        if(nums[n - 1] != nums[n-2]){
            return nums[n - 1];
        }

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right + 1) / 2;
            int t =nums[mid];
            if(t == nums[mid - 1] ) {
                int len = mid - left;
                if(len % 2 == 1) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if( t == nums[mid + 1]) {
                int len = right - mid;
                if(len % 2 == 1) {
                    left = mid -1;
                } else {
                    right = mid;
                }
            } else {
                return nums[mid];
            }

        }
        return -1;
    }
}

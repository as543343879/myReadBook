package com.acm.lico;

/**
 * Solution1 class
 *
 * @author 格林
 * @date 2021-05-14
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i ++) {
            for(int j = i + 1; j < nums.length; j ++) {
                if( nums[i] + nums[j]  == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
}

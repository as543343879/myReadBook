package com.acm.lico;

import java.util.HashMap;
import java.util.Map;

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

    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i ++) {
            if( map.get( target - nums[i]) != null) {
                res[0] = map.get( target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}

package com.acm.lico;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution41 class
 *41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * @author 谢小平
 * @date 2021/6/30
 */
public class Solution41 {
    /**
     * 内存超限
     * @param nums
     * @return
     */
    public int firstMissingPositiveError(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] > max)
                max = nums[i];
        }
        if(max != Integer.MAX_VALUE)
            max ++;
        int[] bitMap = new int[max];
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] < 0)
                continue;
            bitMap[nums[i]] = 1;
        }
        for(int i = 1; i < max; i ++) {
            if(bitMap[i]  == 0) {
                return i;
            }
        }
        return max;
    }

    public int firstMissingPositive(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i : nums) {
            if(i <= 0)
                continue;
            map.put(i,true);
        }
        for(int i = 1; i <= Integer.MAX_VALUE; i ++) {
            if(!map.containsKey(i)) {
                return i;
            }
        }
        return 0;
    }

    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i ++) {
            if(nums[i] < 0) {
                nums[i] = n + 1;
            }
        }
        for(int i = 0; i < n; i ++) {
            int k = Math.abs(nums[i]);
            if(k <= n) {
                nums[k - 1] = - Math.abs(nums[k - 1]);
            }
        }
        for(int i = 0; i < n ; i ++) {
            if(nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }
}

package com.acm.lico;

/**
 * Solution53 class
 *给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 来源：力扣（Lee                     ode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-30
 */
public class Solution53 {
    /**
     *  时间超限
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++) {
            for(int j = i ; j < nums.length; j ++) {
                int sum = 0;
                for(int k = i; k <= j; k ++) {
                    sum += nums[k];
                }
                if(sum > max)
                    max = sum;
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int pre = nums[0];
        int max = pre;
        for(int i = 1; i < nums.length; i ++) {
            pre = Math.max(pre + nums[i],nums[i]);
            if(pre > max)
                max = pre;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        new Solution53().maxSubArray2(nums);
    }
}

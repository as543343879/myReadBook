package com.acm.lico.doNotKnow;

/**
 * Solution334 class
 * https://leetcode.cn/problems/increasing-triplet-subsequence/
 *334. 递增的三元子序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * 示例 2：
 *
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * 示例 3：
 *
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 *
 * @author 谢小平
 * @date 2022/7/22
 */
public class Solution334 {
    /**
     *  贪心
     *  让 fist,sencode 尽可能小
     *  执行结果： 通过 显示详情 添加备注
     *  执行用时： 2 ms , 在所有 Java 提交中击败了 65.67% 的用户
     *  内存消耗： 82.5 MB , 在所有 Java 提交中击败了 22.83% 的用户
     *  通过测试用例： 76 / 76 炫耀一下:
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {

        int first = nums[0];
        int sencond = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] > sencond) {
                return true;
            } else if(nums[i] > first) {
                sencond = nums[i];
            } else {
                first = nums[i];
            }
        }
        return false;
    }
    /**
     *
     * dp[i] 下标 i数值 左边小于i 的个数
     * dp[i] = max(dp[0...i-1] + 1)
     * 还是时间超限
     * @param nums
     * @return
     */
    public boolean increasingTriplet4(int[] nums) {
        int[] dp =  new int[nums.length];
        dp[0] = 0;
        for(int i = 1; i < nums.length; i ++) {
            for(int j = 0; j < i; j ++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1 );
                    if(dp[i] >= 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * 表示右边大于 i 的个数
     * dp[i] = max(dp[i +1] )
     * 时间超限
     * @param nums
     * @return
     */
    public boolean increasingTriplet3(int[] nums) {
        int[] dp =  new int[nums.length];
        dp[nums.length - 1] = 0;
        for(int i = nums.length - 2; i >= 0; i --) {
            for(int j =nums.length - 1; j > i; j --) {
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] >= 2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean res = false;

    /**
     * 时间超限
     * @param nums
     * @return
     */
    public boolean increasingTriplet2(int[] nums) {
        int[] cachedInt =  new int[nums.length];
        for(int i = 0; i < nums.length; i ++) {
            dfs(nums,i, cachedInt);
        }
        return res;
    }
    // cachedNums[i] 大于 i 的个数
    private int dfs(int[] nums, int numIndex, int[] cachedNums) {
        if(res) {
            return 0;
        }
        if(cachedNums[numIndex] != 0) {
            if (cachedNums[numIndex] >= 3) {
                res = true;
                return 0;
            }
            return cachedNums[numIndex];
        }
        cachedNums[numIndex] ++;

        for(int i = numIndex + 1; i < nums.length; i ++ ) {
                if(nums[numIndex] < nums[i]) {
                    cachedNums[numIndex] =  Math.max(cachedNums[numIndex], dfs(nums,i , cachedNums) + 1);
                }
        }
        if(cachedNums[numIndex] >= 3) {
            res = true;
        }
        return  cachedNums[numIndex];

    }


    public static void main(String[] args) {
        int[] testData = {20,100,10,12,5,13};
        System.out.println(new Solution334().increasingTriplet(testData));
    }
}

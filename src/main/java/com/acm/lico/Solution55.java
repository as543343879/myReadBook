package com.acm.lico;

/**
 * Solution55 class
 *55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * 1 复杂度分析 上限 O(n) 下限 O(n2)
 * 2 定位问题 问题类型分析，采用贪心算法
 * 3 数据操作分析 查找 用数组就行
 * 4 编码实现
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * @author 谢小平
 * @date 2021/7/1
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        int n1 = nums.length - 1;
        for(int i = 1 ;  i< nums.length && i <= max ; i ++) {
            max = Math.max( i + nums[i],max);
            if(max >= n1)
                return true;

        }

        if(max >= nums.length - 1) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums =  {3,2,1,0,4};
            new Solution55().canJump(nums);
    }
}

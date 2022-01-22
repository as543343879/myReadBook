package com.acm.lico.greedy;

/**
 * Solution55 class
 * https://leetcode-cn.com/problems/jump-game/submissions/
 *
 * @author 格林
 * @date 2021-12-10
 */

//执行结果： 通过 显示详情 添加备注
//执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
//内存消耗： 39.6 MB , 在所有 Java 提交中击败了 77.60% 的用户
//通过测试用例： 166 / 166
public class Solution55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 1)




            return true;
        int nowLen = nums[0] + 1;
        for(int i = 1; i < nowLen; i ++) {
            int tempLen = i + nums[i]  +1;
            nowLen = nowLen > tempLen ? nowLen: tempLen;
            if(nowLen >= len) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
//        int[] temp = {3,2,1,0,4};
//        int[] temp =  {2,3,1,1,4} ;
        int[] temp = {2,0,0};
        System.out.println(new Solution55().canJump(temp));
    }
}

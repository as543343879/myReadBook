package com.acm.lico.greedy;
/**
 跳跃游戏:55
 2023-10-19 09:48:38
 //给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 //
 // 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums = [2,3,1,1,4]
 //输出：true
 //解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 //
 //
 // 示例 2：
 //
 //
 //输入：nums = [3,2,1,0,4]
 //输出：false
 //解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= nums.length <= 10⁴
 // 0 <= nums[i] <= 10⁵
 //
 //
 // Related Topics 贪心 数组 动态规划 👍 2551 👎 0

 **/
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
//        int[] temp =  {1,0,1,0} ;
        int[] temp = {2,3,1,1,4};
//        int[] temp = {2,0,0};
        System.out.println(new Solution55().canJumpNew20(temp));
    }

    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度
     空间复杂度
     O(1) 一个常量下完成
     O(n) 一次遍历
     O(logn) 折半查询
     O(n^2) 两重嵌套循环查询
     2 定位问题
     根据问题类型，确定采用何种算法思维。
     例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
     思路： 贪心算法
     1. maxlen 记录能去到的最远 下标。
     2. 在[1, maxLen]， 修正能去到的最远 下标。
     3. 如果 最远下标 大于 目标， 就返回。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:2 ms,击败了89.71% 的Java用户
     内存消耗:42.7 MB,击败了65.15% 的Java用户
     */
    public boolean canJumpNew30(int[] nums) {
        if(nums == null) {
            return false;
        }
        if(nums.length == 1) {
            return true;
        }
        int nowLen = nums[0];
        // 记录存放能到的最远距离；
        int  maxLen = nums[0];
        for(int i = 1 ; i <= maxLen; i ++) {
            maxLen = maxLen > nums[i] + i  ? maxLen : nums[i] + i;
            if(maxLen >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度
     空间复杂度
     O(1) 一个常量下完成
     O(n) 一次遍历
     O(logn) 折半查询
     O(n^2) 两重嵌套循环查询
     2 定位问题
     根据问题类型，确定采用何种算法思维。
     例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
     思路：dp[i] 表示i 节点能去的最远距离
     dp[i] = max(dp[i-1] - 1, dp[i]);
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:3 ms,击败了21.27% 的Java用户
     内存消耗:42.5 MB,击败了81.70% 的Java用户
     */
    public boolean canJumpNew21(int[] nums) {
        if(nums == null) {
            return false;
        }
        if(nums.length == 1) {
            return true;
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1 ; i < nums.length; i ++) {
            dp[i] = (dp[i-1] - 1 >= 0) ?  Math.max(dp[i-1] - 1, nums[i]) : 0;
        }
        return dp[nums.length - 2] > 0;
    }

    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度 O(N*M) m 是最大num[i]
     空间复杂度 O(N)
     O(1) 一个常量下完成
     O(n) 一次遍历
     O(logn) 折半查询
     O(n^2) 两重嵌套循环查询
     2 定位问题
     根据问题类型，确定采用何种算法思维。
     例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
     思路：动态规划 dp[i] 是否能到达 ，如果能 那么 dp[i] 那么【dp[i + 1], dp[i + num[i]]】 == true
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:76 ms,击败了10.20% 的Java用户
     内存消耗:42.9 MB,击败了13.26% 的Java用户
     */
    public boolean canJumpNew20(int[] nums) {
        if(nums == null) {
            return false;
        }
        boolean dp[] = new boolean[nums.length];
        dp[0] = true;
        for(int i = 0 ; i < nums.length; i ++) {
            if(dp[i]) {
                for(int j = 1; j <= nums[i]; j ++) {
                    if(i + j >= (nums.length - 1)) {
                        return true;
                    }
                    dp[i + j] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }
}

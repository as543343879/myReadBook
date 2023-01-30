package com.acm.lico.backtracking; /**
 494 ,目标和
 //给你一个整数数组 nums 和一个整数 target 。
 //
 // 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 //
 //
 // 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 //
 //
 // 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums = [1,1,1,1,1], target = 3
 //输出：5
 //解释：一共有 5 种方法让最终目标和为 3 。
 //-1 + 1 + 1 + 1 + 1 = 3
 //+1 - 1 + 1 + 1 + 1 = 3
 //+1 + 1 - 1 + 1 + 1 = 3
 //+1 + 1 + 1 - 1 + 1 = 3
 //+1 + 1 + 1 + 1 - 1 = 3
 //
 //
 // 示例 2：
 //
 //
 //输入：nums = [1], target = 1
 //输出：1
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= nums.length <= 20
 // 0 <= nums[i] <= 1000
 // 0 <= sum(nums[i]) <= 1000
 // -1000 <= target <= 1000
 //
 //
 // Related Topics 数组 动态规划 回溯 👍 1457 👎 0

 **/
/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询

 思考思路：
 时间复杂度 O(2^N)
 空间复杂度  O(N)

 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 思考思路：
 递归+回溯。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果

 思考思路：
 解答成功:
 执行耗时:516 ms,击败了23.93% 的Java用户
 内存消耗:39.2 MB,击败了74.52% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution494 {
    int res;
    public int findTargetSumWays(int[] nums, int target) {
        count(nums,target,0,0);
        return res;
    }

    public void count(int[] nums, int target, int sum, int index) {
        if(index == nums.length) {
            if(target == sum) {
                res++;
            }
            return;
        }
        count(nums, target, sum + nums[index], index + 1);
        count(nums,target, sum - nums[index], index + 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

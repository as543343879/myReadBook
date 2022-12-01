package com.acm.lico.dp; /**
 416 ,分割等和子集
 //给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums = [1,5,11,5]
 //输出：true
 //解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 //
 // 示例 2：
 //
 //
 //输入：nums = [1,2,3,5]
 //输出：false
 //解释：数组不能分割成两个元素和相等的子集。
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= nums.length <= 200
 // 1 <= nums[i] <= 100
 //
 //
 // Related Topics 数组 动态规划 👍 1568 👎 0

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
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 动态规划：
 dp[i][j] 表示 下标[0,j]的nums ，是否存在选区值 等于 j;
 状态转移方程：
 dp[i][j] = { {不选 i dp[i-1][j] , }, {选i num[i] == j dp[i][j] = true,  dp[i][j] = dp[i-1][j-num[j]} (j> num[j]) }

 特殊情况：
 最大值 大于 sum/2 那肯定是false
 如果和为奇数 也肯定为false
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:30 ms,击败了41.82% 的Java用户
 内存消耗:42.4 MB,击败了33.44% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution416 {
    public boolean canPartition(int[] nums) {
        boolean res = false;
        if(nums.length == 1) {
            return res;
        }
        int max = 0;
        int sum  = 0;
        for(int num: nums) {
            max = Math.max(num,max);
            sum += num;
        }
        if(sum % 2 != 0) {
            return res;
        }
        sum /= 2;
        if(max  > sum) {
            return res;
        } else if(max == sum) {
            return true;
        }
        int len = nums.length;
        boolean[][] dp = new boolean[len][sum+1];
        // 优化代码 j == num[i] 的情况
        dp[0][0] = true;
        if(nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }
        for(int i = 1; i < len; i ++) {
            for(int j = 0; j <= sum; j ++) {
                dp[i][j] = dp[i-1][j];
                if(nums[i] <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];

                }

            }
            if(dp[i][sum]) {
                return true;
            }
        }
        return dp[len-1][sum];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

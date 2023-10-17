package com.acm.lico; /**
 53 ,最大子数组和
 //给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 //
 // 子数组 是数组中的一个连续部分。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 //输出：6
 //解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 //
 //
 // 示例 2：
 //
 //
 //输入：nums = [1]
 //输出：1
 //
 //
 // 示例 3：
 //
 //
 //输入：nums = [5,4,-1,7,8]
 //输出：23
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= nums.length <= 10⁵
 // -10⁴ <= nums[i] <= 10⁴
 //
 //
 //
 //
 // 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 //
 // Related Topics 数组 分治 动态规划 👍 5886 👎 0

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

 自己思路：动态规划
 dp[i][j][2] 表示 下标 i-j 的和的最大值
 dp[i][j] =

 官方思路：
 重点： 向右遍历，会不会出现某个数的值， 大于 这个数 + 之前的值。 判断之前的值是否需要继承
 pre = max(num[i], num[i] + pre)
 maxRes = max(maxRest, pre)


 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果

 官方思路：
 解答成功:
 执行耗时:1 ms,击败了100.00% 的Java用户
 内存消耗:50.5 MB,击败了71.35% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution53 {
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N)
     空间复杂度  O(N)
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
     思路： 动态规划 dp[i] 表示 到小标i 的最大和
     动态转移公式： dp[i] =  如果 mus[i] + dp[i-1] > nums[i]  ? mus[i] + dp[i-1] : nums[i] ;
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:2 ms,击败了44.22% 的Java用户
     内存消耗:56.4 MB,击败了37.74% 的Java用户
     */
    public int maxSubArrayNew20(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < nums.length; i ++) {
            int temp = dp[i-1] + nums[i];
            dp[i] = temp > nums[i] ? temp : nums[i];
            if(max < dp[i]) {
                max = dp[i];
            }

        }
        return max;
    }

    public int maxSubArrayNew21(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int pre = 0;
        int res = nums[0];
        for(int i = 0 ; i < nums.length; i ++) {
            pre = Math.max(nums[i], nums[i] + pre);
            res = Math.max(pre, res);
        }
        return res;
    }


    /**
     *  时间超限
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
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

    /**
     * 以前的刷题记录
     * @param nums
     * @return
     */
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
//leetcode submit region end(Prohibit modification and deletion)

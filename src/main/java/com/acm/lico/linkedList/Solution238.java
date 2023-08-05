package com.acm.lico.linkedList; /**
 238 ,除自身以外数组的乘积
 //给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 //
 // 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 //
 // 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 //
 //
 //
 // 示例 1:
 //
 //
 //输入: nums = [1,2,3,4]
 //输出: [24,12,8,6]
 //
 //
 // 示例 2:
 //
 //
 //输入: nums = [-1,1,0,-3,3]
 //输出: [0,0,9,0,0]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 2 <= nums.length <= 10⁵
 // -30 <= nums[i] <= 30
 // 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内
 //
 //
 //
 //
 // 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 //
 // Related Topics 数组 前缀和 👍 1433 👎 0

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
 官方思路：
 定义两个数组， lefts，rights。 lefts[i] 存储i左边的乘积， righs[i] 存储i右边的乘积。 两者相乘 就是结果。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 官方思路：
 解答成功:
 执行耗时:1 ms,击败了100.00% 的Java用户
 内存消耗:49.7 MB,击败了42.84% 的Java用户

 Old 思路：
 执行结果： 通过 显示详情 添加备注
 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
 内存消耗： 50.2 MB , 在所有 Java 提交中击败了 5.06% 的用户
 通过测试用例： 20 / 20
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] lefts = new int[nums.length];
        int[] rights = new int[nums.length];
        lefts[0] = 1;
        rights[nums.length-1] = 1;
        for(int i = 1; i < nums.length; i ++ ) {
            lefts[i] = nums[i-1] * lefts[i-1];
        }

        for(int i = nums.length - 2; i >= 0; i --) {
            rights[i] = nums[i+1] * rights[i+1];
        }
        for(int i = 0; i < nums.length; i ++) {
            nums[i] = lefts[i] * rights[i];
        }
        return nums;
    }

    public int[] productExceptSelfOld(int[] nums) {
        int[] leftNums = new int[nums.length];
        int[] rightNums = new int[nums.length];
        int res = 1;
        leftNums[0] = 1;
        for(int i = 0; i < nums.length; i ++ ) {
            leftNums[i] = res;
            res = nums[i] * res;
        }
        res = 1;
        for(int i =  nums.length-1; i >= 0; i --) {
            rightNums[i] = res;
            res = nums[i] * res;
        }
        int[] reses = new int[nums.length];
        for(int i = 0; i < nums.length; i ++) {
            reses[i] = leftNums[i] * rightNums[i];
        }
        return reses;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

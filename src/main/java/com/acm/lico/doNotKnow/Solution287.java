package com.acm.lico.doNotKnow;

/**
 * Solution287 class
 * https://leetcode.cn/problems/find-the-duplicate-number/
 *287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 *
 * [2,5,9,6,9,3,8,9,7,1]
 * 输出：
 * 7
 * 预期结果：
 * 9
 * @author 谢小平
 * @date 2022/7/15
 */

import com.sun.xml.internal.bind.v2.TODO;

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
 1. 桶排序，数组字典。
 2. 数学规律 1 + ... + n = n * (n + 1) / 2
根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
public class Solution287 {
    // TODO
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (right + left) / 2;
            int count = 0;
            for(int i = 0; i < nums.length; i ++) {
                if(nums[i] >= middle) {
                    count ++;
                }
            }

            if(count >= middle) {
                left = middle;
            } else {
                left = middle;
            }
        }
        return nums[right];
    }
    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 93.31% 的用户
     * 内存消耗： 58.5 MB , 在所有 Java 提交中击败了 66.72% 的用户
     * 通过测试用例： 58 / 58
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
//        System.out.println(slow + ":" + fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[fast];

    }
    /**
     *  时间超限
     * @param nums
     * @return
     */
    public int findDuplicate4(int[] nums) {
        for(int i = 0; i < nums.length; i ++) {
            for(int j = i + 1; j < nums.length; j ++) {
                if(nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }
    /**
     * 思路错误。
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int res = nums.length * (nums.length - 1) / 2;
        if (res == 0) {
            return 1;
        }
        int resCount = 0;
        for(int i: nums) {
            resCount += i;
        }
        return resCount % res;
    }


    public static void main(String[] args) {
        int[] testData = new int[] {1,3,4,3,2};
        testData = new int[] {2,5,9,6,9,3,8,9,7,1};
        System.out.println(new Solution287().findDuplicate(testData));
    }
}

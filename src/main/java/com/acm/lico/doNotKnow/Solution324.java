package com.acm.lico.doNotKnow;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Solution324 class
 * https://leetcode.cn/problems/wiggle-sort-ii/
 *324. 摆动排序 II
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 *
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 * @author 格林
 * @date 2022-07-19
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(NLOGN)
 空间复杂度
 O(N)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
规律题目
 奇数怎么都可以。
 偶数 x = (n + 1) / 2 - 1
 [x][n-1][x-1][n-2] 这样排列。
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
public class Solution324 {
    public void wiggleSort3(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2 - 1;
        int k = n - 1;
        for (int i = 0; i < n; i += 2, x--, k--) {
            nums[i] = arr[x];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }

    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 18.21% 的用户
     * 内存消耗： 44.9 MB , 在所有 Java 提交中击败了 79.16% 的用户
     * 通过测试用例： 52 / 52
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        int[] copyNums = nums.clone();
        Arrays.sort(copyNums);
        int n = nums.length;
        int x = (n + 1) / 2 - 1;
        int k = n -1;
        for(int i = 0; i < n; i +=2, x --, k --) {
            nums[i] =  copyNums[x];
            if(i +1 < n ) {
                nums[i+1] = copyNums[k];
            }
        }


    }
    /**
     * 思路错误
     * @param nums
     */
    public void wiggleSort2(int[] nums) {
        int[] copyNums = new int[nums.length];
        System.arraycopy(nums,0,copyNums,0,copyNums.length);
        Arrays.sort(copyNums);
        int left = 0;
        int n = nums.length;
        if(n == 1) {
            return ;
        }
        int right = n / 2  + 1;
        int index = 0;
        while (index < nums.length ) {
            nums[index ++] =  copyNums[left++];
            if(right < nums.length) {
                nums[index++] = copyNums[right++];
            }
//            nums[index ++] =  copyNums[left++];
        }

        if(nums[n - 1] == nums[n -2]) {
            int t = nums[n -2];
            nums[n-2] = nums[0];
            nums[0] = t;




        }

    }

    public static void main(String[] args) {
        int[] testData = new int[]{
                1,5,1,1,6,4};
        testData = new int[] {1,4,3,4,1,2,1,3,1,3,2,3,3};
        new Solution324().wiggleSort3(testData);
        new Solution324().wiggleSort(testData);

        int k = 1;
        k = +2;
        System.out.println(k);
    }
}

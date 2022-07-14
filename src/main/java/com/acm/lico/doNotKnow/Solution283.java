package com.acm.lico.doNotKnow;

import org.checkerframework.checker.units.qual.K;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Solution283 class
 * https://leetcode.cn/problems/move-zeroes/
 *283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 * @author 格林
 * @date 2022-07-14
 */
public class Solution283 {
    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 49 ms , 在所有 Java 提交中击败了 6.54% 的用户
     * 内存消耗： 42.6 MB , 在所有 Java 提交中击败了 68.87% 的用户
     * 通过测试用例： 74 / 74
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if(nums[left] == 0) {
                while (nums[right] == 0 && right > left) {
                    right --;
                }
                for(int k = left; k < right; k ++) {
                    nums[k] = nums[k + 1];
                }
                nums[right] = 0;
                right++;
            } else {
                left ++;
            }

        }
    }

    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 42 ms , 在所有 Java 提交中击败了 8.16% 的用户
     * 内存消耗： 42.8 MB , 在所有 Java 提交中击败了 44.35% 的用户 通过测试用例： 74 / 74 炫耀一下:
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (nums[right] == 0 && right > left) {
            right --;
        }

        while (left < right) {


            if(nums[left] == 0) {
                int t = left;
                while (nums[t] == 0) {
                     t++;
                }
                int len = t - left ;
                for(int k = t; k <= right; k ++) {
                     nums[k - len] = nums[k];
                }
                for(int k = right - len + 1; k <= right ; k ++) {
                    nums[k] = 0;
                }
                right -= len;
            }
                left ++;


        }
    }

    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 42.9 MB , 在所有 Java 提交中击败了 35.78% 的用户
     * 通过测试用例： 74 / 74
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        // 指向 下一个元素
        for(int right = 0; right < nums.length; right ++) {
            if(nums[right] != 0) {
                nums[left] = nums[right];
                left ++;

            }
        }
        for(int i = left; i < nums.length; i ++) {
            nums[i] = 0;
        }

    }
    public static void main(String[] args) {
        int[] testData = new int[]{0,1,0,3,12};
        new Solution283().moveZeroes(testData);
        System.out.println(Arrays.toString(testData));
    }
}

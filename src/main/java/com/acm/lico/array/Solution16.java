package com.acm.lico.array;

import java.util.Arrays;

/**
 * Solution16 class
 *16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * @author 格林
 * @date 2021-07-26
 */
public class Solution16 {
    /**
     * 执行用时：
     * 142 ms
     * , 在所有 Java 提交中击败了
     * 6.26%
     * 的用户
     * 内存消耗：
     * 37.9 MB
     * , 在所有 Java 提交中击败了
     * 79.59%
     * 的用户
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        if(nums.length < 3) {
            throw new IllegalArgumentException();
        }
        long odlMin  = nums[0] + nums[1]+nums[2] ;
        for(int first = 0; first < nums.length - 2; first ++) {
            int sum = target - nums[first];
            int two = n;
            int three = n - 1;
            while (two - first >= 2) {
                for(int i = two; i >= first + 2; i --) {
                    if(nums[i] <= sum) {
                       two = i != two ? i + 1 : i;
                        break;
                    }  else {
                        two = i;
                    }

                }
                for(int i = first + 1; i < two; i ++) {
                    three = i;
                    int t ;
                    if(Math.abs(odlMin - target) > Math.abs( ( t =nums[three] + nums[two] + nums[first]) - target)) {
                        odlMin = t;
                    }
                }
                two --;
            }

        }
        return (int) odlMin;
    }

    public static void main(String[] args) {
        System.out.println(new Solution16().threeSumClosest(new int[]{0, 2, 1, -3}, 1));
    }

}

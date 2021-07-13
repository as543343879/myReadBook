package com.acm.lico;

import java.util.Arrays;

/**
 * Solution74 class
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 1 复杂度上下限分析，上限 O(n) 下限 O(n2)
 * 2 定位问题类型 确定采用何种算法思维 ， 排序，或者 双指针
 * 3 数据操作
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * @author 谢小平
 * @date 2021/7/12
 */
public class Solution75 {
    /**
     *  算法思维 双指针
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int i01 = 0,i12 = n - 1;

        while (i01 <= i12) {
            int index = i01;
            while (index <= i12 && nums[index] == 1) {
                index++;
            }
            if(index >= i12 + 1)
               break;
            if(nums[index] == 0 ) {
                if(index != i01) {
                    int t = nums[index];
                    nums[index] = nums[i01];
                    nums[i01] = t;
                }
               i01 ++;
            // nums[index] == 2
            } else {
                int t = nums[index];
                nums[index] = nums[i12];
                nums[i12] = t;
                i12--;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        new Solution75().sortColors2(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 算法思维 排序
     * @param nums
     */
    public void sortColors(int[] nums) {
         short[] bit = new short[3];
         for(int i  : nums) {
             bit[i] ++;
         }
         int k = 0;
        for(int i = 0 ; i < 3; i ++) {
            for(int j = 0 ; j < bit[i]; j ++) {
                nums[k++] = i;
            }
        }
    }
}

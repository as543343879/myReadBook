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

    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N)
     空间复杂度  O(1)
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
     思路：
     1. 三个变量记录元素个数。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:39.9 MB,击败了59.43% 的Java用户
     */
    public void sortColorsNew20(int[] nums) {
        int[] counts = new int[3];
        for(int i : nums) {
            counts[i] ++;
        }
        for(int i = 0; i < counts[0]; i ++) {
            nums[i] = 0;
        }
        for(int i = counts[0]; i < counts[1] + counts[0]; i ++) {
            nums[i] = 1;
        }
        for(int i = counts[0] + counts[1]; i < nums.length; i ++) {
            nums[i] = 2;
        }
    }
}

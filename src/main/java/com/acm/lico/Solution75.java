package com.acm.lico;

/**
 * Solution74 class
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * @author 谢小平
 * @date 2021/7/12
 */
public class Solution75 {
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

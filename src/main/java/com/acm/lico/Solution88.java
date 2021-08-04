package com.acm.lico;

/**
 * Solution88 class
 *给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 示例 1：
 *执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗：
 * 38.6 MB
 * , 在所有 Java 提交中击败了
 * 32.24%
 * 的用户
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 谢小平
 * @date 2021/7/30
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = 0;
        for(int i = 0; i < n; i ++) {
            while (k < m &&  nums1[k] <= nums2[i]  ) {
                k++;
            }
            // 到了m的位置
            if( k == m ) {
                m++;
            //找到一个大于 的位置 下标 k。
            } else {
                int x = m;
                m ++;
               while (x > k) {
                   nums1[x] = nums1[x-1];
                   x --;
               }

            }
            nums1[k] = nums2[i];
        }
    }
}

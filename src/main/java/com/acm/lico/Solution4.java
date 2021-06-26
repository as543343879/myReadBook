package com.acm.lico;

/**
 * Solution4 class
 * 4. 寻找两个正序数组的中位数
 *  给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *  方法一 归并排序合并后， 直接定位下表
 *  方法二 双指针走，定位到我们需要的下标。
 *  方法三 找分割线, 左边分割线 满足  (n1 + n2 + 1) / 2 个元素， 然后定位好小数组的下标就可以了。
 * @author 格林
 * @date 2021-06-26
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        int n1 = nums1.length;
        int n2 = nums2.length;

        int leftTotal = (n1 + n2 + 1) / 2;
        int left = 0, right = n1;
        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = leftTotal - i;
            // [left ,i - 1]
            if(nums1[i - 1] > nums2[j]) {
                right = i - 1;
            // [i,right]
            } else  {
                // [left(i),right] 两个元素的时候 左边界不会在小，死循环。 让  i = left + (right - left) / 2;  加1
                left = i;
            }
        }
        int i = left;
        int j = leftTotal - i;
        int num1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int num1rightMin = i == n1 ? Integer.MAX_VALUE :  nums1[i];
        int nmu2leftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int num2rightMin = j == n2 ? Integer.MAX_VALUE : nums2[j];
        // 奇数
        if( (n1 + n2) % 2 == 1) {
           return Math.max(num1LeftMax,nmu2leftMax);
        } else {
            return (double)  (Math.max(num1LeftMax,nmu2leftMax) + Math.min(num1rightMin,num2rightMin) ) / 2.0;
        }
    }


}

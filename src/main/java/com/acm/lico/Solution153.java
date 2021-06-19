package com.acm.lico;

/**
 * Solution153 class
 *153. 寻找旋转排序数组中的最小值
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-19
 */
public class Solution153 {
    public int findMin(int[] nums) {
       int low = 0, high = nums.length - 1;
       while (low < high) {
           int mid = low + (high - low ) / 2;
           if(nums[mid] > nums[high]) {
               low = mid + 1;
           } else {
               high = mid;
           }

       }
       return nums[low];

    }
}

package com.acm.lico;

/**
 * Solution7042 class
 *704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-19
 */
public class Solution7042 {
    public int search(int[] nums, int target) {
        int low = 0;
        int hight = nums.length - 1;
        while (low <= hight) {
            int mid = low + (hight - low ) / 2;
            if(target == nums[mid])
                return mid;
            else if(target > nums[mid]) {
                low = mid + 1;
            } else {
                hight = mid - 1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
//        int[] arr =  {-1,0,3,5,9,12};
        int[] arr =  {9};
        new Solution7042().search(arr,9);
    }
}

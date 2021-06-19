package com.acm.lico;

/**
 * Solution540 class
 *
 * @author 格林
 * @date 2021-06-19
 */
public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
           boolean flag = (high  - mid) % 2 == 0;
           if(nums[mid] == nums[mid + 1]) {
               if(flag) {
                   low = mid + 2;
               } else {
                   high = mid - 1;
               }
           } else if(nums[mid] == nums[mid - 1]) {
               if(flag) {
                   high = mid - 2;
               } else  {
                   low = mid + 1;
               }
           } else {
               return nums[mid];
           }

        }
        return nums[low];
    }


    public static void main(String[] args) {
//        int[] arr = {1,1,2,3,3,4,4,8,8};
        int[] arr = {1};
        System.out.println(new Solution540().singleNonDuplicate(arr));
    }
}

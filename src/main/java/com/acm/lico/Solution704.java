package com.acm.lico;

/**
 * Solution704 class
 *
 * @author 谢小平
 * @date 2020-08-01
 */
public class Solution704 {
	public int search(int[] nums, int target) {
		if(nums.length <= 0) {
			return -1;
		}
		return search(nums, 0, nums.length -1, target);
	}

	public int search(int[] nums, int begin, int end, int target) {
		int mid = (begin + end) /  2 ;
		if(nums[mid] == target) {
			return mid;
		} else if(begin >= end ) {
			return -1;
		} else if(nums[mid] > target) {
			return search(nums, begin, mid-1, target);
		}  else {
			return  search(nums, mid + 1, end, target);
		}
	}

	public static void main(String[] args) {
		Solution704 solution704 = new Solution704();
		int[] arrg = {2,5};
		System.out.println(solution704.search(arrg,0));
	}
}

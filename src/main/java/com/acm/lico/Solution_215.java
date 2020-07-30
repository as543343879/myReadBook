package com.acm.lico;

/**
 * Solution_215 class
 *
 * @author 谢小平
 * @date 2020-07-14
 */
public class Solution_215 {
	class Solution {
		public int findKthLargest(int[] nums, int k) {
			return find(nums,0,nums.length - 1,nums.length - k );
		}
		public int find(int[] nums, int begin, int end, int k) {
			int i = index(nums, begin, end);
			if(i  > k) {
				return find(nums,begin,i - 1, k);
			} else  if( i  < k) {
				return find(nums,i + 1, end, k);
			} else {
				return nums[i];
			}

		}

		public int index(int[] nums, int begin, int end) {
			if(begin < end) {
				int key = nums[begin];
				while (begin < end) {
					while (begin < end && nums[end] > key  ) {
						end --;
					}
					if(begin < end) {
						nums[begin] = nums[end];
						begin ++;
					}
					while (begin < end && nums[begin] < key) {
						begin ++;
					}
					if(begin < end) {
						nums[end] = nums[begin];
						end -- ;
					}

				}
				nums[begin] = key;
			}

			return begin;
		}
	}
}

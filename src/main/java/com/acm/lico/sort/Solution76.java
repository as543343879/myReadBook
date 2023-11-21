package com.acm.lico.sort;

import java.util.Random;

/**
 * Solution76 class
 *
 * @author 格林
 * @date 2023-11-20
 */
public class Solution76 {
        public static void main(String[] args) {
            Solution76 solution76 = new Solution76();
            int[] temps = {3,2,3,1,2,4,5,5,-1};
            int kthLargest = solution76.findKthLargest(temps, 4);
            System.out.println(kthLargest);
        }
        Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
        }

        public int quickSelect(int[] a, int l, int r, int index) {
            int q = randomPartition(a, l, r);
            if (q == index) {
                return a[q];
            } else {
                return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
            }
        }

        public int randomPartition(int[] a, int l, int r) {
//        int i = random.nextInt(r - l + 1) + l;
//        swap(a, i, r);
            return partition(a, l, r);
        }

        public int partition(int[] a, int l, int r) {
            int x = a[r], i = l - 1;
            for (int j = l; j < r; ++j) {
                if (a[j] <= x) {
                    i = i + 1;
                    swap(a, i, j);
                }
            }
            swap(a, i + 1, r);
            return i + 1;
        }

        public void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
}

package com.offer.huawei;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] testData = {1,-1,-3,-2,3};
        System.out.println(Arrays.toString( new Solution().getSubarrayBeauty(testData, 3, 2)));

//        [], k = 2, x = 1

        int[]  testData2 = {-3,1,2,-3,0,-3};
        System.out.println(Arrays.toString( new Solution().getSubarrayBeauty(testData2, 2, 1)));
    }


    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int right = k - 1;
        List<Integer> res = new ArrayList<>();
        List<Integer> tempK = new ArrayList<>(k);
        for(int i = 0; i < right; i ++) {
            tempK.add(nums[i]);
        }
        for(int i = right; i < nums.length; i ++) {
            tempK.add(nums[i]);
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for(Integer t: tempK) {
                priorityQueue.add(t);
            }
            Integer tempRes = 0;
           for(int count = 0;  count < x; count ++) {
               tempRes = priorityQueue.poll();
           }
            res.add( tempRes < 0 ? tempRes : 0);
            tempK.remove(0);
        }
        int[] resArray = new int[res.size()];
        for(int i = 0; i < res.size(); i ++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}
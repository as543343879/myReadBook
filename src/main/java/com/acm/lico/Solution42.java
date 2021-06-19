package com.acm.lico;

/**
 * Solution42 class
 * 42. 接雨水
 * @author 格林
 * @date 2021-06-19
 */
public class Solution42 {
    public int trap(int[] height) {
        if(height.length == 0)
            return 0;
        int[] leftArray = new int[height.length];

         leftArray[0] = height[0];
        for(int i = 1; i < height.length; i ++) {
            leftArray[i] = Math.max(leftArray[i-1],height[i]);
        }

        int[] rightArray = new int[height.length ];
        rightArray[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i --) {
            rightArray[i] = Math.max(rightArray[i + 1],height[i]);
        }
        int res = 0;
        for(int i = 0 ; i < height.length; i ++) {
            res += Math.min(leftArray[i] ,rightArray[i]) - height[i];
        }
        return res;
    }
}

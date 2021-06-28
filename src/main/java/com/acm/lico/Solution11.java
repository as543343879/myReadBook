package com.acm.lico;

/**
 * Solution11 class
 *  盛最多水的容器
 *   给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-27
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i ++) {
            for(int j = i + 1; j < height.length; j ++) {
                res = Math.max(res, Math.min(height[j ] ,height[i]) *(j - i)  );
            }
        }
        return res;
    }

    public int maxArea2(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            res = Math.max(res, Math.min(height[left] ,height[right]) *(right - left)  );
            if(height[left] < height[right]) {
                left ++;
            } else {
                right -- ;
            }
        }
        return res;
    }
}

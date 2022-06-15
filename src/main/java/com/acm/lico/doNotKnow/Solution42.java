package com.acm.lico.doNotKnow;

/**
 * Solution42 class
 * https://leetcode.cn/problems/trapping-rain-water/
 *42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * @author 格林
 * @date 2022-06-13
 */

import javax.validation.constraints.Max;
import java.util.Arrays;

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。

 两边高度最小值减去当前值就是所求的值。

 例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注 执行用时： 1 ms ,
 在所有 Java 提交中击败了 73.96% 的用户 内存消耗： 41.8 MB ,
 在所有 Java 提交中击败了 59.23% 的用户
 通过测试用例： 322 / 322
 */
public class Solution42 {

    /**
     * 执行结果： 通过 显示详情 添加备注 执行用时： 0 ms ,
     * 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 42.4 MB ,
     * 在所有 Java 提交中击败了 6.16% 的用户
     * 通过测试用例： 322 / 322
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax < rightMax) {
                ans += leftMax - height[left];
                left ++;
            } else {
                ans+= rightMax - height[right];
                right --;
            }


        }
        return ans;

    }

    /**
     *  执行结果
     *  执行结果： 通过 显示详情 添加备注 执行用时： 1 ms ,
     *  在所有 Java 提交中击败了 73.96% 的用户 内存消耗： 41.8 MB ,
     *  在所有 Java 提交中击败了 59.23% 的用户
     *  通过测试用例： 322 / 322
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] leftMaxs = new int[height.length];
        int[] rightMaxs = new int[height.length];
        int leftMax = 0;
        for(int i = 0; i < height.length; i ++ ) {
            leftMaxs[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }
        int rightMax = 0;
        for(int i = height.length - 1; i >= 0; i--) {
            rightMaxs[i] = rightMax;
            rightMax = Math.max(rightMax,height[i]);
        }

        int res = 0;
        for(int i = 0; i < height.length; i ++) {
            int tempRes = Math.min(rightMaxs[i] ,leftMaxs[i])  - height[i];
//            System.out.println(tempRes);
            tempRes = tempRes <= 0 ? 0 : tempRes;
            res += tempRes;
        }
//        System.out.println(Arrays.toString(leftMaxs));
//        System.out.println(Arrays.toString(rightMaxs));
//        System.out.println(Arrays.toString(height));
        return res;


    }

    public static void main(String[] args) {
        int[] testData = {
                0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution42().trap(testData));
    }
}

package com.acm.lico; /**
 盛最多水的容器:11
 2023-03-12 11:00:15
 //给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 //
 // 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 //
 // 返回容器可以储存的最大水量。
 //
 // 说明：你不能倾斜容器。
 //
 //
 //
 // 示例 1：
 //
 //
 //
 //
 //输入：[1,8,6,2,5,4,8,3,7]
 //输出：49
 //解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 //
 // 示例 2：
 //
 //
 //输入：height = [1,1]
 //输出：1
 //
 //
 //
 //
 // 提示：
 //
 //
 // n == height.length
 // 2 <= n <= 10⁵
 // 0 <= height[i] <= 10⁴
 //
 //
 // Related Topics 贪心 数组 双指针 👍 4154 👎 0

 **/
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
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。

 自己思路：
 左右两边，两个指针 left, right，往中间靠拢， 碰到更高的， 就重新计算面积， 取max。
 如果 value[left+1] > value[left] left 左移， 否则右移动
 思路错了， 左右移动， 应该是判断 left，right 下标的值。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路，改成  左右移动， 应该是判断 left，right 下标的值。：
 解答成功:
 执行耗时:4 ms,击败了58.93% 的Java用户
 内存消耗:51.5 MB,击败了52.63% 的Java用户

 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxRes = (right - left ) * Math.min(height[left], height[right]);

        while (left < right ) {
            if(height[left] < height[right]) {
                left ++;
                maxRes = Math.max( maxRes, (right - left ) * Math.min(height[left], height[right]) );
            } else  {
                right --;
                maxRes = Math.max( maxRes,  (right - left ) * Math.min(height[left], height[right]) );
            }

        }
        return maxRes;
    }

    /**
     * 暴力搜索
     * @param height
     * @return
     */
    public int maxArea3(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i ++) {
            for(int j = i + 1; j < height.length; j ++) {
                res = Math.max(res, Math.min(height[j ] ,height[i]) *(j - i)  );
            }
        }
        return res;
    }

    /**
     * old 官方答案
     * @param height
     * @return
     */
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
//leetcode submit region end(Prohibit modification and deletion)

package com.acm.lico.stack; /**
84 ,柱状图中最大的矩形
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2178 👎 0

**/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

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
 思路一:
 枚举左右两边 宽度。 时间超限

 思路二：
 以 heights[i] 为高的 长方形。
    - 直到 heights[j] < heights[i]  ( j > i )
 单调栈。

 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 思路二
 解答成功:
 执行耗时:22 ms,击败了70.22% 的Java用户
 内存消耗:53.9 MB,击败了72.55% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution84 {
    /**
     *  时间超限
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int res = 0;
        for(int left = 0; left < heights.length; left ++) {
            int minHight = heights[left];
            for(int right = left; right < heights.length; right ++ ) {
                minHight = Math.min(heights[right], minHight);
                res = Math.max( minHight * (right - left + 1), res );
            }
        }
        return res;
    }


    public int largestRectangleArea(int[] heights) {

        int[]  heightsNew = new int[heights.length + 2];
        System.arraycopy(heights,0, heightsNew,1, heights.length);
        int len = heightsNew.length;
        heightsNew[0] = heightsNew[len-1] = 0;
        Deque<Integer> stack = new ArrayDeque();
        int res = 0;
        stack.offerLast(0);
        for(int i = 1; i < len; i ++) {
            while (heightsNew[i] < heightsNew[stack.peekLast()]) {
                int height = heightsNew[stack.removeLast()];
                int width = i -  stack.peekLast() - 1;
                res = Math.max(res, height * width);
            }
            stack.addLast(i);
        }
        return res;
    }

    /**
     * 单调栈确定左右边界。 每跟柱子的影响返回 * 高度。
     * 每根柱子的影响范围 ，应该是左右两侧，第一根小于当前柱子的存在。
     *
     *
     * 时间
     * 29 ms
     * 击败
     * 49.50%
     * 内存
     * 53.5 MB
     * 击败
     * 73.59%
     *
     * @param heights
     * @return
     */
    /**
     1 复杂度分析
    估算问题中复杂度的上限和下限
     时间复杂度 O(N)
     空间复杂度 O(N)
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
     3 数据操作分析
        根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     */
    public int largestRectangleArea3(int[] heights) {
        int res = 0;
        if(heights.length == 0) {
            return 0;
        }
        LinkedList<Integer> stack  = new LinkedList<>();
        int n = heights.length;
        int[] leftIndex = new int[n];
        int[] rightIndex = new int[n];
        for(int i = 0; i < n; i ++) {
            while ( (!stack.isEmpty()  && heights[stack.peek()] >= heights[i] )) {
                stack.pop();
            }
            leftIndex[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(i);
        }
        stack.clear();

        for(int i = n - 1; i >= 0; i --) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            rightIndex[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for(int i = 0; i < n; i ++) {
            res = Math.max(heights[i] * (rightIndex[i] - leftIndex[i] - 1), res);
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

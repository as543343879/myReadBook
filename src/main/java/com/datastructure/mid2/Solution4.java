package com.datastructure.mid2;

/**
寻找两个正序数组的中位数:4
2025-06-29 21:11:13
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7579 👎 0

**/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution4 {
    /**
     1 复杂度分析
    估算问题中复杂度的上限和下限
     时间复杂度 O(log min(n+m))
     空间复杂度 O(1
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
        二分法：
            寻找 i 和 j, 使得 i + j = (m + n + 1) / 2
            使得 nums1[i - 1] <= nums2[j] && nums1[ i] >= nums2[j - 1]
            特殊处理： n 长度控制 大于 m
                奇数情况 m + n +  1
                i-1 和 j-1 的情况 ， i -1 < 0 ; num[i - 1] = Integer.MIN_VALUE;  J - 1 < 0; num[j - 1] = Integer.MAX_VALUE
     3 数据操作分析
        根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
         执行耗时:1 ms,击败了100.00% 的Java用户
         内存消耗:45.2 MB,击败了26.40% 的Java用户
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(m < n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = n;
        int maxMidLeft = 0, minMidRight = 0;
        while (left <= right) {
            int i = (left + right) / 2; // nums1 的分割点
            int j = (n + m + 1) / 2 - i; // nums2 的分割点
            int numi1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1]; // nums1 分割点左边的最大值 num[i-1]
            int numi = (i == n) ? Integer.MAX_VALUE : nums1[i]; // nums1 分割点右边的最小值 num[1]

            int numj1 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1]; // nums2 分割点左边的最大值 num2[j -1 ]
            int numj = (j == m) ? Integer.MAX_VALUE : nums2[j]; // nums2 分割点右边的最小值 num2[j]

            // 使得 nums1[i - 1] <= nums2[j] && nums1[ i] >= nums2[j - 1]
            if(numi1 <= numj) {
                maxMidLeft = Math.max(numi1, numj1);
                minMidRight = Math.min(numi, numj);
                left = i + 1; // nums1 的分割点向右移动
            } else {
                right = i - 1; // nums1 的分割点向左移动
            }

        }
        return (m + n) % 2 == 0 ? (maxMidLeft + minMidRight) / 2.0 : maxMidLeft;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

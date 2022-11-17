package com.acm.lico.dp;// 不相交的线
//在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
//
// 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
//
//
// nums1[i] == nums2[j]
// 且绘制的直线不与任何其他连线（非水平线）相交。
//
//
// 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
//
// 以这种方法绘制线条，并返回可以绘制的最大连线数。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,4,2], nums2 = [1,2,4]
//输出：2
//解释：可以画出两条不交叉的线，如上图所示。
//但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相
//交。
//
//
//
// 示例 2：
//
//
//
//输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
//输出：3
//
//
//
// 示例 3：
//
//
//
//输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
//输出：2
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 500
// 1 <= nums1[i], nums2[j] <= 2000
//
//
//
//
// Related Topics 数组 动态规划 👍 392 👎 0



/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 O(N*M)
 空间复杂度
 O(N*M)
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询
 2 定位问题
 动态规划 dp[i][j] = num[i]==num[j] ? 1 + dp[i-1][j-1] : max(dp[i-1][j], dp[i][j-1]);
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:5 ms,击败了37.03% 的Java用户
 内存消耗:40.6 MB,击败了95.36% 的Java用户

 maxUncrossedLines2:
 解答成功:
 执行耗时:4 ms,击败了99.46% 的Java用户
 内存消耗:41 MB,击败了58.49% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import java.lang.Math;
class Solution1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int [][] dp = new int[n1 + 1][n2 + 1];
        for(int i = 1; i <= n1; i ++) {
            for(int j = 1; j <= n2; j ++) {
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1] ;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n1][n2];
    }

    public int maxUncrossedLines2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int [][] dp = new int[n1 + 1][n2 + 1];
        for(int i = 1; i <= n1; i ++) {
            int t1 = nums1[i - 1];
            for(int j = 1; j <= n2; j ++) {
                if(t1 == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i-1][j-1] ;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n1][n2];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

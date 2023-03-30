package com.acm.lico; /**
 88 ,合并两个有序数组
 //给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 //
 // 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 //
 // 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并
 //的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 //输出：[1,2,2,3,5,6]
 //解释：需要合并 [1,2,3] 和 [2,5,6] 。
 //合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 //
 //
 // 示例 2：
 //
 //
 //输入：nums1 = [1], m = 1, nums2 = [], n = 0
 //输出：[1]
 //解释：需要合并 [1] 和 [] 。
 //合并结果是 [1] 。
 //
 //
 // 示例 3：
 //
 //
 //输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 //输出：[1]
 //解释：需要合并的数组是 [] 和 [1] 。
 //合并结果是 [1] 。
 //注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 //
 //
 //
 //
 // 提示：
 //
 //
 // nums1.length == m + n
 // nums2.length == n
 // 0 <= m, n <= 200
 // 1 <= m + n <= 200
 // -10⁹ <= nums1[i], nums2[j] <= 10⁹
 //
 //
 //
 //
 // 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
 //
 // Related Topics 数组 双指针 排序 👍 1797 👎 0

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

 自己思路：
 时间复杂度 O(N+M)
 空间复杂度 O(M)

 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 归并排序的，合并的方法。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:41.6 MB,击败了36.72% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = 0, len2 = 0;
        int[] copyNums1 = new int[m];
        int resLen = 0;
        System.arraycopy(nums1,0,copyNums1,0,m);
        while (len1 < m  || len2 < n) {
            if(len1 >= m) {
                nums1[resLen ++] = nums2[len2++];
            } else if(len2 >= n) {
                nums1[resLen ++] = copyNums1[len1++];
            } else {
                if(copyNums1[len1] <= nums2[len2]) {
                    nums1[resLen ++] = copyNums1[len1++];
                } else {
                    nums1[resLen ++] = nums2[len2++];
                }
            }
        }
    }

    /**
     * 旧的答案
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int k = 0;
        for(int i = 0; i < n; i ++) {
            while (k < m &&  nums1[k] <= nums2[i]  ) {
                k++;
            }
            // 到了m的位置
            if( k == m ) {
                m++;
                //找到一个大于 的位置 下标 k。
            } else {
                int x = m;
                m ++;
                while (x > k) {
                    nums1[x] = nums1[x-1];
                    x --;
                }

            }
            nums1[k] = nums2[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

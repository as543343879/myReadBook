package com.acm.lico.sort; /**
 4 ,寻找两个正序数组的中位数
 //给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 //
 // 算法的时间复杂度应该为 O(log (m+n)) 。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums1 = [1,3], nums2 = [2] , 3 / 2 = 1
 //输出：2.00000
 //解释：合并数组 = [1,2,3] ，中位数 2
 //
 //
 // 示例 2：
 //
 //
 //输入：nums1 = [1,2], nums2 = [3,4] ,4 / 2 = 2
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
 // Related Topics 数组 二分查找 分治 👍 6312 👎 0

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
 时间复杂度 O( N + M)
 空间复杂度 O(1)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。

 自己思路：
 长度分别是 N1， N2, 取 N1 + N2 , k1=(N1 + N2 ) / 2 , k2=k1 + (N1 + N2) % 2。的 小标的值
 官方思路：
 *  方法一 归并排序合并后， 直接定位下表
 *  方法二 双指针走，定位到我们需要的下标。
 *  方法三 找分割线, 左边分割线 满足  (n1 + n2 + 1) / 2 个元素， 然后定位好小数组的下标就可以了。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:1 ms,击败了100.00% 的Java用户
 内存消耗:42.4 MB,击败了53.25% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length + nums2.length;

        int target1, target2;
        if(n1 % 2 == 0) {
            target2 = n1 / 2;
            target1 = target2 - 1;
        } else {
            target1 = n1 / 2;
            target2 = target1;
        }
        if(nums1.length == 0 && nums2.length == 0 ) {
            return 0D;
        }
        if(nums1.length == 0) {
            return (nums2[target1] * 1.0 + nums2[target2] * 1.0) / 2;
        }
        if(nums2.length == 0) {
            return (nums1[target1] * 1.0 + nums1[target2] * 1.0) / 2;
        }
        int count = 0;
        int i = 0;
        int j = 0;

        int targetValue1 = 0;
        int targetValue2 = 0;
        while ( count <= target2) {
            if( (j >= nums2.length) || ( i < nums1.length && nums1[i] <= nums2[j]) ) {
                if(count == target1) {
                    targetValue1 = nums1[i];
                }
                if(count == target2) {
                    targetValue2 = nums1[i];
                }
                i ++;
            } else {
                if(count == target1) {
                    targetValue1 = nums2[j];
                }
                if(count == target2) {
                    targetValue2 = nums2[j];
                }
                j ++;

            }
            count ++;
        }
        return (targetValue1 * 1.0 + targetValue2 * 1.0) / 2;
    }

    /**
     * 官方
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        int n1 = nums1.length;
        int n2 = nums2.length;

        int leftTotal = (n1 + n2 + 1) / 2;
        int left = 0, right = n1;
        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = leftTotal - i;
            // [left ,i - 1]
            if(nums1[i - 1] > nums2[j]) {
                right = i - 1;
                // [i,right]
            } else  {
                // [left(i),right] 两个元素的时候 左边界不会在小，死循环。 让  i = left + (right - left) / 2;  加1
                left = i;
            }
        }
        int i = left;
        int j = leftTotal - i;
        int num1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int num1rightMin = i == n1 ? Integer.MAX_VALUE :  nums1[i];
        int nmu2leftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int num2rightMin = j == n2 ? Integer.MAX_VALUE : nums2[j];
        // 奇数
        if( (n1 + n2) % 2 == 1) {
            return Math.max(num1LeftMax,nmu2leftMax);
        } else {
            return (double)  (Math.max(num1LeftMax,nmu2leftMax) + Math.min(num1rightMin,num2rightMin) ) / 2.0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

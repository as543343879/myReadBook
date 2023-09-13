package com.acm.lico.sort; /**
 * 4 ,寻找两个正序数组的中位数
 * //给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * //
 * // 算法的时间复杂度应该为 O(log (m+n)) 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums1 = [1,3], nums2 = [2] , 3 / 2 = 1
 * //输出：2.00000
 * //解释：合并数组 = [1,2,3] ，中位数 2
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums1 = [1,2], nums2 = [3,4] ,4 / 2 = 2
 * //输出：2.50000
 * //解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * //
 * //
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // nums1.length == m
 * // nums2.length == n
 * // 0 <= m <= 1000
 * // 0 <= n <= 1000
 * // 1 <= m + n <= 2000
 * // -10⁶ <= nums1[i], nums2[i] <= 10⁶
 * //
 * //
 * // Related Topics 数组 二分查找 分治 👍 6312 👎 0
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
    public static void main(String[] args) {
        System.out.println(new Solution4().findMedianSortedArrays(new int[]{1,3},new int[] {2}));
    }
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(lg(min(n,m)))
     空间复杂度  O(1)
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
     思路：数组 A,B  寻找一条分割线，i,j。保证 A[i] >= B[j-1] && A[i-1] <= B[j]。 这样的分割线 就是 两个数组的中卫线。
     1. 可能出现 i ,j  数组越界的情况
     2. 当 m + n 为偶数时候， 左边元素个数 (n + m) / 2
     3. 当 m + n  为奇数时候， 左边元素个数 (n + m + 1) / 2
     4. 统一处理， 左边元素个数 (n + m + 1) / 2 , 这样不用奇偶，只需要确定一个数组分割线的位置，另一个分割线位置可以通过公式计算出来。

     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:1 ms,击败了100.00% 的Java用户
     内存消耗:43.5 MB,击败了30.88% 的Java用户
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 保证第一个数组长度比较短， 这样 leftTotal-i 才能保证，不会数组越界。
        if(nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = 0;
        int right = len1;
        int leftTotal = (len1 + len2 + 1) / 2;
        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = leftTotal - i;
            if(nums1[i - 1] > nums2[j]) {
                // 要在 num1[left,i-1] 中寻找
                right = i - 1;
            } else {
                // 要在 num1[i,right] 中寻找
                // 假如 只有两个元素 num1[left, right] 会进入死循环，所以这里 要加1   int i = left + (right - left + 1) / 2;
                left = i;
            }
        }
        int i = left;
        int j = leftTotal - i;
        // 已经能确定 分割线 左右的4个值了， 但是要考虑 一些边界情况， 保证 边界情况不能被取到。
        int leftMaxValue1 = i == 0 ? Integer.MIN_VALUE : nums1[i-1];
        int leftMaxValue2 = j == 0 ? Integer.MIN_VALUE : nums2[j-1];

        int rightMinValue1 = i == len1 ? Integer.MAX_VALUE : nums1[i];
        int rightMinValue2 = j == len2 ? Integer.MAX_VALUE : nums2[j];

        // 奇数
        if(((len1 + len2) & 1) == 1) {
            return Math.max(leftMaxValue1, leftMaxValue2);
        } else {
            return ( Math.max(leftMaxValue1, leftMaxValue2) + Math.min(rightMinValue1, rightMinValue2) ) / 2.0;
        }

    }
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(logN) 错误， 应该是 O(N)
     空间复杂度  O(1)
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
     思路：
     择半查找 定位分割线。 假如 长度 分别位 n , m 。 假如 下标 i，j 分别满足 i + j = n - i + m - j并且  s[i-1] < s2[j] & s2[j-1] < s[i]
     如果是len 是奇数 res = max(s[i-1], s2[j-1])
     如果len 是偶数 res = (max(s[i-1], s2[j-1]) + min(s[i], s[j-1]) * 1.0 / 2.9;
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:1 ms,击败了100.00% 的Java用户
     内存消耗:43.5 MB,击败了17.71% 的Java用户
     */
    public double findMedianSortedArraysOld(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        boolean even = len % 2 == 0;
        int targetIndex = (len + 1) / 2;
        if (even) {
            targetIndex += 1;
        }

        int i = 0, j = 0;
        int count = 0;
        boolean isI = true;
        boolean isPreI = true;
        while (i < len1 || j < len2) {
            isPreI = isI;
            if (i >= len1) {
                j++;
                isI = false;
            } else if (j >= len2) {
                i++;
                isI = true;
            } else {
                if (nums1[i] < nums2[j]) {
                    i++;
                    isI = true;
                } else {
                    j++;
                    isI = false;
                }
            }

            if (i + j == targetIndex) {
                break;
            }
        }

        if (even) {
            if (isI == isPreI) {
                if (isI) {
                    return (nums1[i - 2] + nums1[i - 1]) * 1.0 / 2;
                } else {
                    return (nums2[j - 2] + nums2[j - 1]) * 1.0 / 2;
                }
            } else {
                return (nums1[i - 1] + nums2[j - 1]) * 1.0 / 2;
            }
        } else {
            return (isI ? nums1[i - 1] : nums2[j - 1]) * 1.0;
        }


    }

    public double findMedianSortedArraysAbstraction(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0) return (left + right) / 2.0;
        else return right;
    }

    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int n1 = nums1.length + nums2.length;

        int target1, target2;
        if (n1 % 2 == 0) {
            target2 = n1 / 2;
            target1 = target2 - 1;
        } else {
            target1 = n1 / 2;
            target2 = target1;
        }
        if (nums1.length == 0 && nums2.length == 0) {
            return 0D;
        }
        if (nums1.length == 0) {
            return (nums2[target1] * 1.0 + nums2[target2] * 1.0) / 2;
        }
        if (nums2.length == 0) {
            return (nums1[target1] * 1.0 + nums1[target2] * 1.0) / 2;
        }
        int count = 0;
        int i = 0;
        int j = 0;

        int targetValue1 = 0;
        int targetValue2 = 0;
        while (count <= target2) {
            if ((j >= nums2.length) || (i < nums1.length && nums1[i] <= nums2[j])) {
                if (count == target1) {
                    targetValue1 = nums1[i];
                }
                if (count == target2) {
                    targetValue2 = nums1[i];
                }
                i++;
            } else {
                if (count == target1) {
                    targetValue1 = nums2[j];
                }
                if (count == target2) {
                    targetValue2 = nums2[j];
                }
                j++;

            }
            count++;
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
        if (nums1.length > nums2.length) {
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
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
                // [i,right]
            } else {
                // [left(i),right] 两个元素的时候 左边界不会在小，死循环。 让  i = left + (right - left) / 2;  加1
                left = i;
            }
        }
        int i = left;
        int j = leftTotal - i;
        int num1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int num1rightMin = i == n1 ? Integer.MAX_VALUE : nums1[i];
        int nmu2leftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int num2rightMin = j == n2 ? Integer.MAX_VALUE : nums2[j];
        // 奇数
        if ((n1 + n2) % 2 == 1) {
            return Math.max(num1LeftMax, nmu2leftMax);
        } else {
            return (double) (Math.max(num1LeftMax, nmu2leftMax) + Math.min(num1rightMin, num2rightMin)) / 2.0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

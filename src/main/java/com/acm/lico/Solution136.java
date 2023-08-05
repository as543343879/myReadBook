package com.acm.lico; /**
 136 ,只出现一次的数字
 //给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 //
 // 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 //
 //
 //
 //
 //
 //
 //
 // 示例 1 ：
 //
 //
 //输入：nums = [2,2,1]
 //输出：1
 //
 //
 // 示例 2 ：
 //
 //
 //输入：nums = [4,1,2,1,2]
 //输出：4
 //
 //
 // 示例 3 ：
 //
 //
 //输入：nums = [1]
 //输出：1
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= nums.length <= 3 * 10⁴
 // -3 * 10⁴ <= nums[i] <= 3 * 10⁴
 // 除了某个元素只出现一次以外，其余每个元素均出现两次。
 //
 //
 // Related Topics 位运算 数组 👍 2813 👎 0

 **/

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
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 先排序，然后再比对。

 官方思路：
 异或， 异或满足交换律

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路；
 解答成功:
 执行耗时:5 ms,击败了31.81% 的Java用户
 内存消耗:41.2 MB,击败了83.54% 的Java用户

 官方思路：
 解答成功:
 执行耗时:1 ms,击败了98.77% 的Java用户
 内存消耗:41.6 MB,击败了34.06% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution136 {

    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int res = nums[0];
        for(int i = 1; i < nums.length; i ++) {
            res ^= nums[i];
        }
        return res;
    }
    /**
     *     先排序，然后再比对。
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        if(nums == null) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n - 1; i +=2) {
            if(nums[i] != nums[i +1]) {
                return nums[i];
            }
        }
        return nums[n-1];
    }

    /**
     * 以前刷的答案
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        Arrays.sort(nums);

        if(nums[0] != nums[1]) {
            return nums[0];
        }
        if(nums[n - 1] != nums[n-2]){
            return nums[n - 1];
        }

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right + 1) / 2;
            int t =nums[mid];
            if(t == nums[mid - 1] ) {
                int len = mid - left;
                if(len % 2 == 1) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if( t == nums[mid + 1]) {
                int len = right - mid;
                if(len % 2 == 1) {
                    left = mid -1;
                } else {
                    right = mid;
                }
            } else {
                return nums[mid];
            }

        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

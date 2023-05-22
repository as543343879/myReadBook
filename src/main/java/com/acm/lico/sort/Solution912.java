package com.acm.lico.sort; /**
 912 ,排序数组
 //给你一个整数数组 nums，请你将该数组升序排列。
 //
 //
 //
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums = [5,2,3,1]
 //输出：[1,2,3,5]
 //
 //
 // 示例 2：
 //
 //
 //输入：nums = [5,1,1,2,0,0]
 //输出：[0,0,1,1,2,5]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= nums.length <= 5 * 10⁴
 // -5 * 10⁴ <= nums[i] <= 5 * 10⁴
 //
 //
 // Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 840 👎 0

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
 时间复杂度
    O(NlogN)
 空间复杂度 错误
    O(NlogN)| O(N)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 堆排序，归并排序 都可以
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:28 ms,击败了73.31% 的Java用户
 内存消耗:53.6 MB,击败了42.35% 的Java用户

 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution912 {
    public int[] sortArray(int[] nums) {
        if( nums == null || nums.length == 0) {
            return nums;
        }
        mergeSort(0,nums.length - 1, nums);
        return nums;
    }
    private void mergeSort(int left, int right, int[] nums) {
        if(left >= right) {
            return;
        }
        int middle = (right + left ) / 2;
        mergeSort(left, middle, nums);
        mergeSort(middle+1, right, nums);
        merge(left,right,nums);
    }

    private void merge(int left, int right, int[] nums) {
        if(left >= right) {
            return;
        }
        int len = right - left + 1;
        int[] tempNums = new int[len];
        int middle = (right + left) / 2 - left;
        System.arraycopy(nums,left, tempNums, 0, len);
        int startIndex = left;
        right = middle + 1 ;
        left = 0;
        while (left <= middle && right < len) {
            nums[startIndex++] =  tempNums[left] <= tempNums[right] ?  tempNums[left++]:  tempNums[right++];
        }
        while (left <= middle) {
            nums[startIndex++] =  tempNums[left];
            left ++;
        }
        while (right < len) {
            nums[startIndex++] =  tempNums[right];
            right ++;
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)

package com.acm.lico;

/**
 * Solution class
 *26. 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * @author 格林
 * @date 2021-06-27
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int left= 0, right = 1;
        int n = nums.length;
        while (right < n) {
            if(nums[right] != nums[right - 1]) {
                left++;
                nums[left] = nums[right];
            }
            right ++;
        }
        return left + 1;
    }

    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N)
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
     1. resIndex 一个指针执行期望的结果索引， 第二个指针  index 指向处理的数据。
     2. 用pre 记录 前一个值， 用  value 记录 第二个指针指向的值。
     3. 如果pre ！= value, num[redsIndex++] = value 否则 index++；
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:1 ms,击败了27.45% 的Java用户
     内存消耗:42.8 MB,击败了61.11% 的Java用户
     */
    public int removeDuplicatesNew20(int[] nums) {
        int index = 1;
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] != nums[i - 1]) {
                nums[index ++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1111,222,333};
    }
}

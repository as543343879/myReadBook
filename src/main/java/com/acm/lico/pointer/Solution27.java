package com.acm.lico.pointer; /**
 移除元素:27
 2023-01-11 22:10:32
 //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 //
 // 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 //
 // 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 //
 //
 //
 // 说明:
 //
 // 为什么返回数值是整数，但输出的答案是数组呢?
 //
 // 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 //
 // 你可以想象内部操作如下:
 //
 //
 //// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 //int len = removeElement(nums, val);
 //
 //// 在函数里修改输入数组对于调用者是可见的。
 //// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 //for (int i = 0; i < len; i++) {
 //    print(nums[i]);
 //}
 //
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums = [3,2,2,3], val = 3
 //输出：2, nums = [2,2]
 //解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而
 //nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 //
 //
 // 示例 2：
 //
 //
 //输入：nums = [0,1,2,2,3,0,4,2], val = 2
 //输出：5, nums = [0,1,4,0,3]
 //解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面
 //的元素。
 //
 //
 //
 //
 // 提示：
 //
 //
 // 0 <= nums.length <= 100
 // 0 <= nums[i] <= 50
 // 0 <= val <= 100
 //
 //
 // Related Topics 数组 双指针 👍 1620 👎 0

 **/
/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度 O(N)
 空间复杂度 O(1)
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

 双指针：
 当左边指针等于val ,找到右边指针不不为val 的进行交换
 当 left == right时，如果 nums[left] == val 时， left --。
 如果left = -1 , 要返回0
 当左边指针不等于val，长度相机。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:39.9 MB,击败了66.63% 的Java用户

 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution27 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if(nums[left] == val) {
                while (nums[right] == val && right >left ) {
                    right--;
                }
                if(right == left) {
                    if(nums[right] == val) {
                        left --;
                    }
                    return left == -1 ? 0 : left + 1;
                    // nums[right] != val
                } else {
                    nums[left] = nums[right];
                    right--;
                }
            }

            left ++;

        }
//        if(left == right && left == 0 && nums[0] == val) {
//            return  0;
//        }
        return left  ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

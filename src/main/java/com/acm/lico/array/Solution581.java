/**
 最短无序连续子数组:581
 2022-12-20 15:13:56
 //给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 //
 // 请你找出符合题意的 最短 子数组，并输出它的长度。
 //
 //
 //
 //
 //
 // 示例 1：
 //
 //
 //
 //
 //输入：nums = [2,6,4,8,10,9,15]
 //输出：5
 //解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 //
 //
 // 示例 2：
 //
 //
 //输入：nums = [1,2,3,4]
 //输出：0
 //
 //
 // 示例 3：
 //
 //
 //输入：nums = [1]
 //输出：0
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= nums.length <= 10⁴
 // -10⁵ <= nums[i] <= 10⁵
 //
 //
 //
 //
 // 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 //
 // Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 974 👎 0

 **/

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
 自己思路： 错误
 两个指针 ，分别指向头尾， 然后两个 单独栈。实现。

 官网思路1： 先排序，对比左右两边元素的不同。


 官网思路2:
 分为 A ， B(left, right), C 三段
 B 中都小于 C中
 A 中都大于 C中
 left, 一定是从右到左维护一个min(num[i] <= min),最后一个 mum[i] > min 的值。
 right, 一定是从左到右维护一个max(num[i] >= max), 最后一个 num[i] < max 的值。



 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution581 {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int min = nums[n-1];
        int max = nums[0];
        int left=-1, right = 0;
        for(int i = 0 ; i < n; i ++) {
            if( nums[i] >= max) {
                max = nums[i];
            } else {
                left = i;
            }

            if( nums[n-i-1] <= min) {
                min = nums[n-i-1];
            } else {
                right = n-i-1;
            }
        }
        return left - right  + 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int left = 1, right = nums.length -2;
        LinkedList<Integer> stackMin = new LinkedList<Integer>();
        LinkedList<Integer> stackMax = new LinkedList<Integer>();

        stackMin.add(0);
        stackMax.add(right + 1);
        while (left < right) {
            if(nums[left] >= nums[stackMin.peek()] ) {
                stackMin.add(left);
                left ++;
            }
            if(nums[right] <= nums[stackMax.peek()] ) {
                stackMax.add(right);
                right -- ;
            }

            if(nums[left] < nums[stackMin.peek()] &&  nums[right] > nums[stackMax.peek()]) {
                break;
            }
        }


        return right - left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

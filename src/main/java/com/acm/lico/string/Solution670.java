package com.acm.lico.string;

/**
 最大交换:670
 2023-10-24 15:48:11
 //给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 //
 // 示例 1 :
 //
 //
 //输入: 2736
 //输出: 7236
 //解释: 交换数字2和数字7。
 //
 //
 // 示例 2 :
 //
 //
 //输入: 9973
 //输出: 9973
 //解释: 不需要交换。
 //
 //
 // 注意:
 //
 //
 // 给定数字的范围是 [0, 10⁸]
 //
 //
 // Related Topics 贪心 数学 👍 411 👎 0

 **/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution670 {
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
     思路：
     1. 转换成字符数组，然后循环进行交换
     2. 记录交换的最大值。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:1 ms,击败了49.42% 的Java用户
     内存消耗:38.1 MB,击败了59.26% 的Java用户
     */
    public int maximumSwap(int num) {
        char[] numChars = String.valueOf(num).toCharArray();
        int max = num;
        for(int i = 0; i < numChars.length; i ++) {
            for(int j = i + 1; j < numChars.length; j ++) {
                swap(numChars, i , j);
                max = Math.max(max , Integer.valueOf(new String(numChars)));
                swap(numChars, i , j);
            }
        }
        return max;
    }

    private void swap(char[] nums, int i, int j) {
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

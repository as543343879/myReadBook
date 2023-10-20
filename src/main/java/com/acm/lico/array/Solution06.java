package com.acm.lico.array;

/**
 拿硬币:LCP 06
 2023-10-20 16:12:47
 //桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 //
 // 示例 1：
 //
 //
 // 输入：[4,2,1]
 //
 //
 // 输出：4
 //
 // 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 //
 // 示例 2：
 //
 //
 // 输入：[2,3,10]
 //
 //
 // 输出：8
 //
 // 限制：
 //
 //
 // 1 <= n <= 4
 // 1 <= coins[i] <= 10
 //
 //
 // Related Topics 数组 数学 👍 122 👎 0

 **/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution06 {
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
     就是每堆 对2 取余的次数。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:38.7 MB,击败了46.81% 的Java用户
     */
    public int minCount(int[] coins) {
        int res = 0;
        for(int t : coins) {
            res += (t & 1 )+t / 2;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

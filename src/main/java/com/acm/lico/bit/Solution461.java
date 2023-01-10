package com.acm.lico.bit; /**
 汉明距离:461
 2023-01-10 21:38:17
 //两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 //
 // 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：x = 1, y = 4
 //输出：2
 //解释：
 //1   (0 0 0 1)
 //4   (0 1 0 0)
 //       ↑   ↑
 //上面的箭头指出了对应二进制位不同的位置。
 //
 //
 // 示例 2：
 //
 //
 //输入：x = 3, y = 1
 //输出：1
 //
 //
 //
 //
 // 提示：
 //
 //
 // 0 <= x, y <= 2³¹ - 1
 //
 //
 // Related Topics 位运算 👍 663 👎 0

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
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 不断取最后一位 异或。

 更好的方法是 直接 ^ , 然后求1 的个数。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:38.9 MB,击败了7.05% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution461 {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while(x != 0 || y != 0) {
            int x1 = x & 1;
            int y1 = y & 1;
            if(x1 + y1 == 1) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

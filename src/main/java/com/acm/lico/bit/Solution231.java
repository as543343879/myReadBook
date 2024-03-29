package com.acm.lico.bit; /**
 231 ,2 的幂
 //给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 //
 // 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：n = 1
 //输出：true
 //解释：2⁰ = 1
 //
 //
 // 示例 2：
 //
 //
 //输入：n = 16
 //输出：true
 //解释：2⁴ = 16
 //
 //
 // 示例 3：
 //
 //
 //输入：n = 3
 //输出：false
 //
 //
 // 示例 4：
 //
 //
 //输入：n = 4
 //输出：true
 //
 //
 // 示例 5：
 //
 //
 //输入：n = 5
 //输出：false
 //
 //
 //
 //
 // 提示：
 //
 //
 // -2³¹ <= n <= 2³¹ - 1
 //
 //
 //
 //
 // 进阶：你能够不使用循环/递归解决此问题吗？
 //
 // Related Topics 位运算 递归 数学 👍 578 👎 0

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
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */

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
 时间复杂度 O(logN）
 空间复杂度 O(logN)
 官方思路：
 时间复杂度 O(1）
 空间复杂度 O(1)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 递归：对n 不断 / 2 。确定递归出的条件

 官方思路
 2^n 二进制 , 假如二进制是  1000000 之类 n-1 是 0111111

 自己思路新：
 2^n 的二进制 只有一个1.

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:1 ms,击败了22.35% 的Java用户
 内存消耗:38.3 MB,击败了99.66% 的Java用户

 官方思路：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:38.6 MB,击败了72.66% 的Java用户

 自己思路新：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:38.7 MB,击败了45.38% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution231 {

    public boolean isPowerOfTwo4(int n) {
        if(n <= 0) {
            return false;
        }
        int bitCount = Integer.bitCount(n);
        return bitCount == 1;
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 &&( n & (n-1)) == 0;
    }
    public boolean isPowerOfTwo2(int n) {
        if(n == 1) {
            return true;
        } else if( n == 0) {
            return false;
        }
        if(n % 2 != 0) {
            return false;
        }
        n /= 2;
        return isPowerOfTwo2(n);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

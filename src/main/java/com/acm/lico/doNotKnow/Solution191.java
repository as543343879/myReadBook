package com.acm.lico.doNotKnow;

/**
 * Solution191 class
 * https://leetcode.cn/problems/number-of-1-bits/
 *91. 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 *
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 提示：
 *
 * 输入必须是长度为 32 的 二进制串 。
 *
 *
 * 进阶：
 *
 * 如果多次调用这个函数，你将如何优化你的算法？
 * @author 谢小平
 * @date 2022/6/30
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
 2 定位问题
 n = 01 n&k | n & (k->1)
 n = 0011
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
public class Solution191 {
    // you need to treat n as an unsigned value

    /**
     * 执行结果： 通过 显示详情 添加备注 
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 
     * 内存消耗： 38.8 MB , 在所有 Java 提交中击败了 11.53% 的用户 
     * 通过测试用例： 601 / 601
     * @param n
     * @return
     */
    public   int hammingWeight(int n) {
        n = (0x55555555 & n)  +  ((n>>1) & 0x55555555);
        System.out.println(Integer.toBinaryString(n));
        n = (0x33333333 & n)  + (0x33333333 & (n >> 2));
        System.out.println(Integer.toBinaryString(n));
        n = (0x0f0f0f0f & n) + (0x0f0f0f0f &(n >> 4));
        System.out.println(Integer.toBinaryString(n));
        n = n * 0x01010101;
        System.out.println(Integer.toBinaryString(n));
        n = n >> 24;
        System.out.println(Integer.toBinaryString(n));
        return n;
    }
    public static void main(String[] args) {
//        System.out.println(new Solution191().hammingWeight(0b000000001000000001000000001000000001) );
        System.out.println(new Solution191().hammingWeight(0b000011111111111111111111111111111111) );
//        test();
    }

    /**
                              0000 0001 0000 0001 0000 0001 0000 0001
                    0000 0001 0000 0001 0000 0001 0000 0001
          0000 0001 0000 0001 0000 0001 0000 0001
0000 0001 0000 0001 0000 0001 0000 0001




     */
    public static  void test() {
        long start = 0b1111_1111_1111_1111_1111_1111_1111_1111;
        long next = 0b00000001000000010000000100000001;
        long res = start * next;
        System.out.println(res >>> 24);
        System.out.println(Long.toBinaryString(res));
//        System.out.println(Long.toBinaryString(hammingWeight(start)));
        String strSpace = "                                  ";
        String str0 = "00000000000000010000000000000000";
        String str2 = "00000001000000010000000100000001";

    }
}

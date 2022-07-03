package com.acm.lico.doNotKnow;

import java.math.BigInteger;

/**
 * Solution190 class
 * https://leetcode.cn/problems/reverse-bits/
 *190. 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 *
 *
 * 示例 1：
 *
 * 输入：n = 0000001010010100 0001111010011100
 * 输出：964176192 (0011100101111000 0010100101000000)
 * 解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * 示例 2：
 *
 * 输入：n = 11111111111111111111111111111101
 * 输出：3221225471 (10111111111111111111111111111111)
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *      因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 *
 *
 *
 * 进阶: 如果多次调用这个函数，你将如何优化你的算法？
 * @author 谢小平
 * @date 2022/6/29
 */

public class Solution190 {
    // you need treat n as an unsigned value

    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 5.32% 的用户
     * 内存消耗： 41.4 MB , 在所有 Java 提交中击败了 5.12% 的用户
     * 通过测试用例： 600 / 600
     * @param n
     * @return
     */
    public int reverseBits2(int n) {
        String value = new StringBuffer(Integer.toBinaryString(n)).reverse().toString();
        int len0 = 32 - value.length();
        int index = -1;
        for(int i = 0; i < value.length(); i ++) {
            if(value.charAt(i) != '0') {
                index = i;
                break;
            }
        }
        if(len0 > 0) {
            StringBuilder tempBuilder = new StringBuilder();
            for(int i = 0; i < len0; i ++) {
                tempBuilder.append('0');
            }
            value += tempBuilder.toString();
        }

        if (index == -1) {
            return 0;
        } else if(index > 0) {
            value = value.substring(index);
        }
        return new BigInteger(value,2).intValue();
//        return Math.toIntExact(Long.valueOf(value, 2));
    }
    public static void main(String[] args) {
        int t = 0b11111111111111111111111111111101;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.reverse(t));
        //3221225471
        //3221225471
        //2147483647
        //   3221225471 (10111111111111111111111111111111)
        //               10111111111111111111111111111111
//        Integer s =  Integer.valueOf("",2);
        System.out.println(new Solution190().reverseBits(t));
    }

    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 5.12% 的用户
     * 通过测试用例： 600 / 600
     * @param n
     * @return
     */
    private int reverseBits(int n) {
        return Integer.reverse(n);
    }
}

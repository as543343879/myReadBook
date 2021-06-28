package com.acm.lico;

/**
 * Solution29 class
 * 数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * @author 格林
 * @date 2021-06-27
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        if(dividend == 0)
            return 0;
        if(divisor == 1)
            return dividend;
        if(divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
//            if(dividend < Integer.MIN_VALUE)
//                return Integer.MIN_VALUE;
//            else if(dividend > Integer.MAX_VALUE)
//                return Integer.MAX_VALUE;
        }
        long res = 0;
        // true 正数， false 负数
        boolean flag = true;
        if((dividend < 0 && divisor > 0) ||  (dividend > 0 && divisor < 0)) {
            flag = false;
        }
        long last = dividend;
        long idiv =  divisor;
        last = last < 0 ? -last : last;
        idiv = idiv < 0 ? -idiv : idiv;
        // 除法逻辑
        if(last < idiv) {
            return 0;
        }
        long count = 0;
        long idiv4 = idiv * 4;
        while (last >= idiv4) {
            last -= idiv4;
            count += 4;
        }
        long idiv2 = idiv + idiv;
        if (last >= idiv2) {
            last -= idiv2;
            count += 2;
        }
        if(last >= idiv) {
            last -= idiv;
            count ++;
        }
        count = flag ? count : -count;
        if(count > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(count < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) count;
    }
    public static void main(String[] args) {
        System.out.println(-2147483648 * -1);
        System.out.println(new Solution29().divide(-2147483648, 2));
    }
}

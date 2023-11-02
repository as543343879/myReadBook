package com.acm.lico;

/**
 * Solution29 class
 * 29  数相除
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
     思路：除法 转 减法
     1. 对 1 -1  特殊处理
     2. 取符号。如果是负数 返回的时候返回就行
     3. 如果 dividend 大于 divisor 就减少  divisor， 然后结果 res + 1。 直到 devidend 小于divisor.
     问题：
     转符号的时候会出现 负数最大值 容易出现问题。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:1527 ms,击败了5.02% 的Java用户
     内存消耗:38.6 MB,击败了47.80% 的Java用户
     */
    public int divideNew20(int dividend, int divisor) {
        if(dividend == 0) {
            return 0;
        } else if(divisor == 1) {
            return dividend;
        }else if( divisor == -1) {
            if(dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return - dividend;
        }
        boolean sign = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        int res = 0;
        if(dividend == Integer.MIN_VALUE) {
            if(sign) {
                dividend += divisor;
            } else {
                dividend -= divisor;
            }
            res = 1;
        }
        if(divisor == Integer.MIN_VALUE) {
            return res;
        }

        dividend = dividend < 0 ? -dividend: dividend;
        divisor = divisor < 0 ? -divisor : divisor;

        while (dividend >= divisor) {
            dividend -= divisor;
            res ++;
        }

        return sign ? -res : res;

    }

    /**
     * 因为精度溢出， 所有 直接用 负数计算。
     * 解答成功:
     * 	执行耗时:1623 ms,击败了5.02% 的Java用户
     * 	内存消耗:38.4 MB,击败了83.37% 的Java用户
     * @param dividend
     * @param divisor
     * @return
     */
    public int divideNew21(int dividend, int divisor) {
        if(dividend == 0) {
            return 0;
        } else if(divisor == 1) {
            return dividend;
        }else if( divisor == -1) {
            if(dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return - dividend;
        }
        boolean sign = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        int res = 0;
        dividend = dividend < 0 ? dividend: -dividend;
        divisor = divisor < 0 ? divisor : -divisor;

        while (dividend <= divisor) {
            dividend -= divisor;
            res ++;
        }
        return sign ? -res : res;

    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(-2147483648 * -1);
        System.out.println(new Solution29().divideNew20(-1010369383, -2147483648));
        System.out.println(new Solution29().divideNewCopy(7,2));
    }

    public int divideNewCopy(int dividend, int divisor) { // 被除数 除数
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE; // 溢出
        int sign = 1;
        if((dividend > 0 && divisor < 0)||(dividend < 0 && divisor > 0))
            sign = -1;
        // if(divisor == 1) return dividend;
        // if(divisor == -1) return -dividend;
        int a = dividend>0 ? -dividend : dividend;
        int b = divisor>0 ? -divisor : divisor;
        // 都改为负号是因为int 的范围是[2^31, 2^31-1]，如果a是-2^32，转为正数时将会溢出
        //System.out.println(a + " " + b);
        if(a > b) return 0;
        int ans = div(a,b);
        return sign == -1 ? -ans : ans;
    }
    int div(int a, int b)
    {
        if(a > b) return 0;
        int count = 1;
        int tb = b;
        while(tb+tb >= a && tb+tb < 0){ // 溢出之后不再小于0
            tb += tb;
            count += count;
            //System.out.println(tb + " " + count + " " + count*b);
        }
        return count+div(a-tb,b);
    }

}

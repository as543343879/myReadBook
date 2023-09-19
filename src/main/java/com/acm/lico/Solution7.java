package com.acm.lico;

/**
 * Solution7 class
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 思路一 利用字符串反转效率特别查。
 * 思路二 自己反转, 操作之前判断是否 超出
 *
 * @author 格林
 * @date 2021-06-27
 */
public class Solution7 {
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(n) 一次遍历
     空间复杂度  O(1) 一个常量下完成
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
     1. 从结尾开始，用队列的方式， 先进，先出。 的字符串数 就是我们要的结果
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:1 ms,击败了48.59% 的Java用户
     内存消耗:38.7 MB,击败了23.92% 的Java用户
     */
    public int reverseNew2(int x) {
        // 是负数
        boolean isNegative = x < 0;
        if(isNegative) {
            if(x == Integer.MIN_VALUE) {
                return 0;
            }
            x = -x;
        }
        char[] chars = String.valueOf(x).toCharArray();
        StringBuilder sb = new StringBuilder();
        if(isNegative){
            sb.append("-");
        }
        int j = chars.length - 1 ;
        while (j >= 0) {
            if(chars[j] != '0') {
                break;
            }
            j --;
        }
        for(int i = j; i >= 0; i --) {
            sb.append(chars[i]);
        }
        String sRes = sb.toString();
        if(isNegative) {
            if(sRes.length() >= Integer.valueOf(Integer.MIN_VALUE).toString().length() &&  sRes.compareTo(Integer.valueOf(Integer.MIN_VALUE).toString()) > 0) {
                return 0;
            }
        } else {
            if(sRes.length() >= Integer.valueOf(Integer.MAX_VALUE).toString().length() &&  sRes.compareTo(Integer.valueOf(Integer.MAX_VALUE).toString()) > 0) {
                return 0;
            }
        }
        return sRes == "" ? 0 : Integer.valueOf(sRes);
    }

    public static int reverse(long x) {
        boolean isNegative = x < 0;
        String strX = String.valueOf(x);
        if (isNegative) {
            strX = strX.substring(1);
        }
        StringBuilder newString = new StringBuilder(strX);
        newString.reverse();
        strX = newString.toString();
        String maxStr = Integer.MAX_VALUE + "";
        String minStr = Integer.MIN_VALUE + "";
        if ((strX.length() >= maxStr.length() && strX.compareTo(maxStr) > 0) || (strX.length() >= minStr.length() && strX.compareTo(minStr) < 0)) {
            return 0;
        }
        return isNegative ? -Integer.valueOf(strX) : Integer.valueOf(strX);
    }

    /**
     * 解答成功:
     * 	执行耗时:1 ms,击败了49.49% 的Java用户
     * 	内存消耗:38.4 MB,击败了94.87% 的Java用户
     * @param x
     * @return
     */
    public static int reverse4(int x) {
        int res = 0;
        while (x != 0) {
            int temp = res * 10 + x % 10;
            if(temp / 10 != res) {
                return 0;
            }
            res = temp;
            x /= 10;
        }
        return res;
    }

    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int t = x % 10;
            x = x / 10;
            res = res * 10 + t;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse4(1111111119));
    }


    /**
     * 解答成功:
     * 执行耗时:3 ms,击败了8.03% 的Java用户
     * 内存消耗:38.6 MB,击败了76.86% 的Java用户
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean isNegative = x < 0;
        String strX = x + "";
        if (isNegative) {
            strX = strX.substring(1);
        }
        StringBuffer sb = new StringBuffer(strX);
        sb.reverse();

        String maxValue = Integer.MAX_VALUE + "";
        long temp = Integer.MAX_VALUE + 1L;
        String minValue = temp + "";
        strX = sb.toString();
        if (isNegative) {
            if (strX.length() >= minValue.length() && strX.compareTo(minValue) > 0) {
                return 0;
            }
        } else {
            if (strX.length() >= maxValue.length() && strX.compareTo(maxValue) > 0) {
                return 0;
            }
        }


        return isNegative ? -Integer.valueOf(strX) : Integer.valueOf(strX);

    }
}

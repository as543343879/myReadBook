package com.acm.lico;

/**
 * Solution7 class
 * 7. 整数反转
 *  给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 *  思路一 利用字符串反转效率特别查。
 *  思路二 自己反转, 操作之前判断是否 超出
 * @author 格林
 * @date 2021-06-27
 */
public class Solution7 {
    public int reverse(int x) {
        boolean isNegative  = x < 0 ;
        String strX = String.valueOf(x);
        if(isNegative) {
            strX = strX.substring(1);
        }
        StringBuilder newString = new StringBuilder(strX);
        newString.reverse();
        strX = newString.toString();
        String maxStr = Integer.MAX_VALUE + "";
        String minStr = Integer.MIN_VALUE + "";
        if(( strX.length() >=  maxStr.length()  && strX.compareTo(maxStr) > 0) || (  strX.length() >=  minStr.length() && strX.compareTo(minStr) < 0 )) {
            return 0;
        }
        return  isNegative  ? - Integer.valueOf(strX) : Integer.valueOf(strX);
    }
    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            if(res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int t = x % 10;
            x = x / 10;
            res = res*10 + t;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(-112319 % 10);
    }
}

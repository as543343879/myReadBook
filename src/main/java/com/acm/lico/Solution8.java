package com.acm.lico;

/**
 * Solution8 class
 *
 * @author 格林
 * @date 2021-06-27
 */
public class Solution8 {
    public int myAtoi(String s) {
        if(s == null|| s.length() == 0) {
            return 0;
        }
        long res = 0;
        boolean isRes = true;
        // 0 未初始化 1 正数 2 负数
        byte isNegative = 0;
        int i = 0;
        do {
            char c = s.charAt(i);
             if( (c == '-' || c == '+' ) && isRes) {
                 if(isNegative == 0) {
                     if(c == '-') {
                         isNegative = 2;
                     } else {
                         isNegative = 1;
                     }
                 } else {
                     return (int) res;
                 }
            }
            else if( c >= '0' && c <= '9') {
                 if(isRes) {
                     isRes = false;
                     res = isNegative == 2 ? - (c - '0') :  c - '0';
                 }
                 for(int j = i + 1; j < s.length()  ; j ++) {
                     c = s.charAt(j);
                     if(c >= '0' && c <= '9') {

                         res = res * 10 + ( isNegative == 2 ? - (c- '0') : c - '0');
                         if(res > Integer.MAX_VALUE  ) {
                             return Integer.MAX_VALUE;
                         } else if(res < Integer.MIN_VALUE ) {
                             return Integer.MIN_VALUE;
                         }
                     } else {
                         return (int) res;
                     }
                 }
                 return (int) res;
            // if(c != ' ')
            } else  {
                if(! (c == ' ' && isNegative == 0 ))
                 return (int) res;
            }
             i ++;
        } while (i < s.length());
        return (int) res;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
       System.out.println( new Solution8().myAtoi(" + 412"));
    }
}

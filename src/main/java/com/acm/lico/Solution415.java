package com.acm.lico;

/**
 * Solution415 class
 * 415. 字符串相加
 * @author 格林
 * @date 2021-06-19
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int er = 0,sum;
        while ( i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            sum = n1 + n2  + er;
            stringBuilder.append(sum % 10);
            er = sum / 10;
            i --;
            j --;
        }
        if(er == 1)
            stringBuilder.append("1");
        return stringBuilder.reverse().toString();
    }
}

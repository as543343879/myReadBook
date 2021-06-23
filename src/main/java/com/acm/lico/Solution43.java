package com.acm.lico;

/**
 * Solution43 class
 * 43. 字符串相乘
 * 大数相乘
 * @author 格林
 * @date 2021-06-19
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];
        int n1, n2,sum;
        for(int i = n - 1; i >= 0 ; i --) {
             n1 = num1.charAt(i) - '0';
            for(int j = m - 1; j >= 0; j --) {
                n2 = num2.charAt(j) - '0';
                sum = (result[i + j  + 1] + n1 * n2);
                result[i + j + 1] = sum % 10;
                result[i + j ] += sum / 10;
            }
        }
        StringBuilder resultStr = new StringBuilder();
        for(int i = 0; i < result.length; i ++) {
            if(i == 0 &&  result[i] == 0)
                continue;
            resultStr.append(result[i]);
        }
        return resultStr.toString();
     }
}

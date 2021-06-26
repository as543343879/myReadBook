package com.offer;

/**
 * StringTest class
 *
 * @author 格林
 * @date 2021-06-05
 */
public class StringTest {
    public static void main(String[] args) {
        System.out.println(getLCS("abcde","bcd"));
    }
    public static int getLCS(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        int result = 0;
        int sLength = s.length();
        int tLength = t.length();
        int[][] dp = new int[sLength + 1][tLength + 1];
        for (int i = 1; i <= sLength; i++) {
            for (int k = 1; k <= tLength; k++) {
                if (s.charAt(i - 1) == t.charAt(k - 1)) {
                    dp[i][k] = dp[i - 1][k - 1] + 1;
                    result = Math.max(dp[i][k], result);
                }
            }
        }
//        for (int i = 1; i <= sLength + 1; i++) {
//            for (int k = 1; k <= tLength + 1; k++) {
//                System.out.print(dp[i - 1][k - 1] + " ");
//            }
//            System.out.println();
//        }
        return result;
    }
}

package com.acm.lico;

/**
 * Solution5 class
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * @author 格林
 * @date 2021-06-21
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 0 )
            return null;
        int max = 0;
        int start = 0;
        for(int i = 0; i < s.length() ; i ++) {
            int jiLen = maxPalindrome(s, i, i);
            int ouLen = maxPalindrome(s, i, i + 1);
            int t = Math.max(jiLen, ouLen);
             if(max < t) {
                 max = t;
                 start = i - (max - 1) / 2;
             }
        }
        return s.substring(start,max  + start);
    }

    private int maxPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return right - left - 1;
    }

}

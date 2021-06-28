package com.acm.lico;

/**
 * Solution28 class
 *28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 *
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * @author 格林
 * @date 2021-06-27
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0  )
            return 0;
        int needleLen = needle.length();
        for(int i = 0; i + needleLen <= haystack.length(); i ++ ) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int j = i + 1;
                int k = 1;
                while (j < haystack.length() && k < needleLen && (haystack.charAt(j) == needle.charAt(k))) {
                    j ++;
                    k ++;
                }
                if(k == needleLen ){
                    return i;
                }
            }

        }

        return -1;
    }
}

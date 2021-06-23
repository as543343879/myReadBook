package com.acm.lico;

/**
 * Solution165 class
 *
 * @author 格林
 * @date 2021-06-22
 */
public class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length ;
        int len2 = v2.length ;
        int maxLen = Math.max(len1,len2);
        for(int i = 0; i < maxLen; i ++) {
            int str1, str2;
            str1 = i >= len1 ? 0 : Integer.parseInt(v1[i]);
            str2 = i >= len2 ? 0 : Integer.parseInt(v2[i]);
            if(str1 > str2) return 1;
            else if(str1 < str2) return -1;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(new Solution165().compareVersion("0.1","1.1"));
    }
}

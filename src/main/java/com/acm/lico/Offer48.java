package com.acm.lico;

import java.util.HashMap;
import java.util.Map;

/**
 * Offer48 class
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * @author 格林
 * @date 2021-06-19
 */
public class Offer48 {
    // tabcabcbb
    //  i  j
    //  1  4

    /**
     *  复杂度
     *      时间复杂度 O(n)
     *      空间复杂度 O(1) map 里存在字符 是有个数限制的，字符满足 ascii码，最多128个。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> map = new HashMap<>();
        int temp = 0 , result = 0;
        for(int j = 0; j < s.length(); j ++) {
            char cj = s.charAt(j);
            int i = map.getOrDefault(cj,-1);
            map.put(cj,j);
            temp = temp < j - i ?  temp + 1 : j - i;
            result = Math.max(temp,result);
        }
        return result;
    }
}

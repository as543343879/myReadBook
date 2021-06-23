package com.acm.lico;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution3 class
 *
 * @author 格林
 * @date 2021-06-22
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int right =  - 1;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for(int left = 0; left < len; left ++ ) {
            if(left != 0) {
                set.remove(s.charAt(left - 1));
            }

            while (right + 1 < len && !set.contains(s.charAt(right + 1)) ) {
                set.add(s.charAt(right + 1));
                right++;
            }
            if((right - left +1) > max) {
                max = right - left + 1;
            }

        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("bbb"));
    }
}

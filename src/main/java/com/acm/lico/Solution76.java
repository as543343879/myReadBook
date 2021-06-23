package com.acm.lico;

/**
 * Solution76 class
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-21
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        char[] charss =  s.toCharArray();
        char[] charst = t.toCharArray();

        int[] minsHash = new int[128];
        int[] tHash = new int[128];
        for(int i = 0; i < charst.length; i ++) {
            tHash[charst[i]] ++;
        }
        int distant = 0;
        int slen = s.length(), tlen = t.length();
        int minLen = slen + 1;
        int start = 0;
        int left = 0,right = 0;
        while (right < slen ) {
            if(tHash[charss[right]] == 0) {
                right++;
                continue;
            }
            if(minsHash[charss[right]] < tHash[charss[right]]) {
                distant ++;
            }

            minsHash[charss[right]] ++;
            right ++;

            while (distant == tlen) {
                if(right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                if(tHash[charss[left]] == 0) {
                    left++;
                    continue;
                }
                if(minsHash[charss[left]] == tHash[charss[left]]) {
                   distant --;
                }

                minsHash[charss[left]] -- ;
                left ++;
            }
        }
        if(minLen == slen + 1) {
            return "";
        }

        return s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        new Solution76().minWindow("ADOBECODEBANC"
                ,"ABC");
    }
}

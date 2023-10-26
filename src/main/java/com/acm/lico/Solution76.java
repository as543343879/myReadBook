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


    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N +M)
     空间复杂度  O(N+M)
     O(1) 一个常量下完成
     O(n) 一次遍历
     O(logn) 折半查询
     O(n^2) 两重嵌套循环查询
     2 定位问题
     根据问题类型，确定采用何种算法思维。
     例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
     思路：
     1. 用distant 表示 窗口的长度, 如果它的长度 == tLen 说明 覆盖了 maps。mapt 是 目标t 的个数， maps 是 窗口的 个数
     2. distant 加的情况。 maps[i] <  mapt[i]。 这里 假如后面的 在 mapt 也不会在增加。
     3. distant 减少的情况。 mapt[i] == maps[i]
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:2 ms,击败了98.75% 的Java用户
     内存消耗:42.5 MB,击败了86.55% 的Java用户
     */
    public String minWindowNew20(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        char[] charsT = t.toCharArray();
        char[] charsS = s.toCharArray();
        int[] mapT = new int[128];
        int[] mapS = new int[128];
        for(char i : charsT) {
            mapT[i] ++;
        }
        int tLen = charsT.length;
        int begein = 0;
        int minLean = charsS.length + 1;

        int left = 0;
        int right = 0;
        int distant = 0;
        while (right < s.length()) {
            char rightT = charsS[right];
            if(mapT[rightT] == 0) {
                right ++;
                continue;
            }
            if(mapS[rightT] <  mapT[rightT] ) {
                distant ++;
            }
            mapS[rightT] ++;
            right ++;
            while (distant == tLen) {
                char leftChar = charsS[left];
                if(mapT[leftChar] == 0) {
                    left ++;
                    continue;
                }
                if(minLean > right - left) {
                    minLean = right - left;
                    begein = left;
                }
                if(mapS[leftChar] == mapT[leftChar] ) {
                    distant -- ;
                }
                mapS[leftChar] --;
                left ++ ;
            }
        }
        return minLean == charsS.length + 1 ? "" : s.substring(begein, minLean + begein);
    }
    public static void main(String[] args) {
        new Solution76().minWindowNew20("ADOBECODEBANC"
                ,"ABC");
    }
}

package com.acm.lico.string; /**
438 ,找到字符串中所有字母异位词
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1047 👎 0

**/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询

 时间复杂度 O(M +  (N-M + 1) * 26)
 空间复杂度 O(N)
 2 定位问题
根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 滑动窗口+ 字典。
 1. 先根据p，建立字典。
 2. 找到第一个在p中的的字符
 p作为字典
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 findAnagrams
 解答成功:
 执行耗时:561 ms,击败了12.28% 的Java用户
 内存消耗:42.8 MB,击败了15.70% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || p == null) {
            return res;
        }
        int[] pMap = new int[26];
        char[] pChars = p.toCharArray();
        int pLen = p.length();
        for(char t : pChars){
            pMap[t-'a'] ++;
        }
        int n = s.length() - pLen ;
        for(int i = 0; i <= n; i ++ ) {
            if(isEqueal(s,i,pLen,pMap)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean isEqueal(String s, int startIndex,  int pLen , int[] pMap) {
        pLen+= startIndex;
        if(pLen > s.length()) {
            return  false;
        }
        int[] tempMap = new int[26];
        for(int i = startIndex; i < pLen; i ++) {
            tempMap[s.charAt(i)-'a'] ++;
        }
        for(int i = 0; i < 26; i ++) {
            if(pMap[i] != tempMap[i]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package com.acm.lico.doNotKnow;

import java.util.*;

/**
 * Solution139 class
 *https://leetcode.cn/problems/word-break/
 * @author 谢小平
 * @date 2022/5/24
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class Solution139 {
    Boolean res_info = false;

    /**
     * 直接模拟 时间超限
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Collections.sort(wordDict, (o1, o2) -> o2.length() - o1.length());
        return dfs(s,0,wordDict);
    }

    public boolean dfs(String s,int start, List<String> wordDict) {
        if(res_info) {
            return true;
        }

        if(s.length() == start) {
            res_info = true;
            return true;

        } else if(s.length() < start) {
            return false;
        }
        System.out.println(start);
        List<String> canList = isCanFind(s,start,wordDict);
        if(canList.size() == 0) {
            return false;
        }
        for(String temp: canList) {
            if(dfs(s,start + temp.length(), wordDict)) {
                return true;
            }
        }
        return false;

    }

    public List<String> isCanFind(String s, int start, List<String> wordDict) {
        List<String> res = new LinkedList<>();
        for (String key : wordDict) {
            Boolean can = true;
            for(int i = 0; i < key.length(); i ++) {
                if(( start + i < s.length())  && (s.charAt(start + i) != key.charAt(i) )) {
                    can = false;
                }
            }
            if (can) {
                res.add(key);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] ss = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
//        String s = "aaaaaaa";
//        String[] ss = {"aaaa", "aa"};
        System.out.println(s);
        List<String> wordDict = Arrays.asList(ss);
        System.out.println(new Solution139().wordBreak(s,wordDict));
    }
}

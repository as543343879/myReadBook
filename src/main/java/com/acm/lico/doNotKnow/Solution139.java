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
     1 复杂度分析
    估算问题中复杂度的上限和下限
     时间复杂度
        O(N^2)
     空间复杂度
        O(n) 一次遍历

     2 定位问题
    根据问题类型，确定采用何种算法思维。
        动态规划
        例如
         这个问题是什么类型（排序、查找、最优化）的问题；
         这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
         采用哪些数据结构或算法思维，能把这个问题解决。
     3 数据操作分析
        根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     执行结果： 通过 显示详情 添加备注
     执行用时： 7 ms , 在所有 Java 提交中击败了 59.24% 的用户
     内存消耗： 41.8 MB , 在所有 Java 提交中击败了 9.58% 的用户 通过测试用例： 45 / 45
     */
    public boolean wordBreak(String s, List<String> wordDict) {
       Set<String> wordSet = new HashSet<>(wordDict);
       boolean[] dp = new boolean[s.length() + 1];
       dp[0]=true;
       for(int i = 1; i <= s.length(); i ++) {
           for(int j = 0; j < i; j ++) {
               if(dp[j] && wordSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
               }

           }
       }
       return dp[s.length() ];
    }


    /**
     * 直接模拟 时间超限
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
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

package com.acm.lico;

/**
 * Solution14 class
 *14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * @author 格林
 * @date 2021-06-27
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder commonPre = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i ++) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j ++) {
                if(strs[j].length() < i + 1) {
                    return commonPre.toString();
                }
                if(strs[j].charAt(i) != c) {
                    return commonPre.toString();
                }
            }
            commonPre.append(c);
        }
        return commonPre.toString();
    }

}

package com.acm.lico;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution49 class
 *字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * @author 谢小平
 * @date 2021/6/30
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        for(int i = 0; i < strs.length; i ++) {
            int left = i + 1; // 指向不等于str[i] 下个位置
            int right = i; // 指向i + 个数
            for (int j = i + 1; j < strs.length; j ++) {
                if(isRight(strs[i],strs[j])) {
                    right ++ ;
//                    if(right == left) {
//                        left ++;
//                    } else {
                        String t = strs[j];
                        strs[j] = strs[left];
                        strs[left] = t;
                        left ++;
//                    }

                }
            }
            List<String> list = new ArrayList<>();
            for(int k = i; k <= right; k ++) {
                list.add(strs[k]);
            }
            lists.add(list);
            i = right;
        }
        return lists;
    }

    public boolean isRight(String str1, String str2) {
        if(str1.length() != str2.length()){
            return false;
        }
        byte[] bitMap = new byte[26];
        byte[] bitMap2 = new byte[26];
        for(int i = 0; i < str1.length(); i ++){
            bitMap[str1.charAt(i)-'a']  ++;
            bitMap2[str2.charAt(i)-'a']  ++;
        }
        for (int i = 0; i < 26; i ++) {
            if(bitMap[i] != bitMap2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        new Solution49().groupAnagrams(strs);
    }
}

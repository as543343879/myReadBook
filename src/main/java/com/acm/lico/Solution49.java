package com.acm.lico;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Solution49 class
 * 49 字母异位词分组
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
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N) 错误 O(N klogK) klogk 是排序的时间。
     空间复杂度  O(N) 错误 O(NK)
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
     1. 建立一个map，key为排序后的字符串，value为list，存放异位词。
     2. 便利完成后， map.values()即为结果。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     解答成功:
     执行耗时:5 ms,击败了99.28% 的Java用户
     内存消耗:45.7 MB,击败了37.95% 的Java用户
     5 执行结果
     */
    public List<List<String>> groupAnagramsNew20(String[] strs) {
        Map<String, List<String>> resMap = new HashMap<>();
        for(String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> resMapValue = resMap.get(key);
            if(resMapValue == null) {
                resMapValue = new ArrayList<>();
                resMap.put(key, resMapValue);
            }
            resMapValue.add(str);
        }

        return new ArrayList<List<String>>(resMap.values());
    }
    /**
     * jdk8 lambda
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        return  new ArrayList<List<String>>( Arrays.stream(strs).collect(Collectors.groupingBy(o -> {
            char[] chars = o.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        })).values());

    }
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

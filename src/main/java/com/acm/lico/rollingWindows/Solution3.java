package com.acm.lico.rollingWindows;

import java.util.*;/**
无重复字符的最长子串:3
2025-02-24 23:17:20
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcekfabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10621 👎 0

**/
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度 O(N ）
 空间复杂度 O（n) N 种字符
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
    滑动窗口； left 是从做开始， right 是不重复； 以后right 都是从right 开始
根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
     解答成功:
     解答成功:
     执行耗时:6 ms,击败了66.19% 的Java用户
     内存消耗:44 MB,击败了18.60% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        Set<Character> dict = new HashSet<>();
        char[] chars = s.toCharArray();
        int right = 0;
        for(int left = 0; left < chars.length; left ++) {
            if(left != 0) {
                dict.remove(chars[left - 1]);
            }
            while (right < chars.length && !dict.contains(chars[right])) {
                dict.add(chars[right]);
                right ++;
            }
            res = Math.max(res, right - left );
        }
        return res;
    }

    /**
     *  1 复杂度分析
     * 估算问题中复杂度的上限和下限
     *  时间复杂度
     *  空间复杂度
     *     O(1) 一个常量下完成
     *     O(n) 一次遍历
     *     O(logn) 折半查询
     *     O(n^2) 两重嵌套循环查询
     *  2 定位问题
     * 根据问题类型，确定采用何种算法思维。
     *     例如
     *      这个问题是什么类型（排序、查找、最优化）的问题；
     *      这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     *      采用哪些数据结构或算法思维，能把这个问题解决。
     *  3 数据操作分析
     *     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     *  4 编码实现
     *  5 执行结果
     *      解答成功:
     *          执行耗时:15 ms,击败了11.80% 的Java用户
     *          内存消耗:43.8 MB,击败了47.66% 的Java用户
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        LinkedHashMap<Character,Integer> listMap = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for(int left = 0; left < s.length(); left ++) {
            char temp = chars[left];
            if(listMap.containsKey(temp)) {
                res = res > listMap.size() ? res : listMap.size();
                // 删除 temp 之前的元素
                removePre(listMap, temp);
            }
            listMap.put(temp,left);
        }
        res = res > listMap.size() ? res : listMap.size();
        return res;

    }

    private void removePre(LinkedHashMap<Character,Integer> listMap, Character key) {
        if(listMap != null && !listMap.isEmpty() ) {
            Iterator<Map.Entry<Character, Integer>> iterator = listMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> next = iterator.next();
                iterator.remove();
                if(next.getKey().equals(key)) {
                    break;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

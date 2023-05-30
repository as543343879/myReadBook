package com.acm.lico; /**
 3 ,无重复字符的最长子串
 //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 //
 //
 //
 // 示例 1:
 //
 //
 //输入: s = "abcabcbb"
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
 // Related Topics 哈希表 字符串 滑动窗口 👍 9184 👎 0

 **/

import com.acm.lico.Solution3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询
 自己思路：
 时间复杂度 O(N^2)
 空间复杂度 O(N)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 1. 从左开始下标 leftIndex，一直找到 rightIndex 与 leftIndex开始的下标重复， 记录长度为 max，
 2. 如果max 大于之前的max， 进行记录。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:63 ms,击败了12.46% 的Java用户
 内存消耗:43.4 MB,击败了5.00% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        for(int leftIndex = 0; leftIndex < chars.length; leftIndex ++) {
            int rightINdex = leftIndex + 1;
            map.put(chars[leftIndex], leftIndex);
            while (rightINdex < chars.length && !map.containsKey(chars[rightINdex]) ) {
                map.put(chars[rightINdex], rightINdex);
                rightINdex ++;
            }
            max = Math.max(max, rightINdex - leftIndex);
            leftIndex = rightINdex < chars.length ? map.get(chars[rightINdex]) : chars.length;
            map.clear();
        }
        return max;
    }

    public int lengthOfLongestSubstringOld(String s) {
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
//leetcode submit region end(Prohibit modification and deletion)

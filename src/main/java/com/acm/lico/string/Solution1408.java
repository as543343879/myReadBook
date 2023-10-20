package com.acm.lico.string;

import java.util.ArrayList;
import java.util.List;

/**
 数组中的字符串匹配:1408
 2023-10-20 11:01:48
 //给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 //
 // 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 words[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符
 //串。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：words = ["mass","as","hero","superhero"]
 //输出：["as","hero"]
 //解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
 //["hero","as"] 也是有效的答案。
 //
 //
 // 示例 2：
 //
 //
 //输入：words = ["leetcode","et","code"]
 //输出：["et","code"]
 //解释："et" 和 "code" 都是 "leetcode" 的子字符串。
 //
 //
 // 示例 3：
 //
 //
 //输入：words = ["blue","green","bu"]
 //输出：[]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= words.length <= 100
 // 1 <= words[i].length <= 30
 // words[i] 仅包含小写英文字母。
 // 题目数据 保证 每个 words[i] 都是独一无二的。
 //
 //
 // Related Topics 数组 字符串 字符串匹配 👍 101 👎 0

 **/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1408 {
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度
     空间复杂度
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
     1. 暴力解法， 遍历每个字符串，判断 这个字串是否被其他子串包含。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:3 ms,击败了91.32% 的Java用户
     内存消耗:40.1 MB,击败了66.67% 的Java用户
     */
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        if(words == null) {
            return res;
        }
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j ++) {
                if(i != j) {
                    if(words[j].contains(words[i])) {
                        res.add(words[i]);
                        break;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

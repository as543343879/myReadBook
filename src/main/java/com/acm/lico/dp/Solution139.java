package com.acm.lico.dp;
// 单词拆分
// 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
//
//
//
// 示例 1：
//
//
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
//
//
// 示例 2：
//
//
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
//
//
// 示例 3：
//
//
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s 和 wordDict[i] 仅有小写英文字母组成
// wordDict 中的所有字符串 互不相同
//
//
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1855 👎 0

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 O(N^2)
 空间复杂度
 O(N)

 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询
 2 定位问题
 字典树，或者动态规划
 dp[i] 表示 中前 i 个字符， 能否 用 s[n]  进行拆分的结果 是否可以利用字典中出现的单词拼接出 s 。
 dp[i] = dp[j] && check(j,i)
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析 包含
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:7 ms,击败了55.09% 的Java用户
 内存消耗:41.5 MB,击败了66.33% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int sLen = s.length();
        boolean dp[] = new boolean[sLen + 1];
        dp[0] = true;
        for(int i = 1; i <= sLen; i ++ ) {
            for(int j = 0; j < i  ; j ++) {
                if(dp[j] && wordDictSet.contains(s.substring(j,i)))  {
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[sLen];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package com.acm.lico.dp; /**
 10 ,正则表达式匹配
 //给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 //
 //
 // '.' 匹配任意单个字符
 // '*' 匹配零个或多个前面的那一个元素
 //
 //
 // 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 //
 // 示例 1：
 //
 //
 //输入：s = "aa", p = "a"
 //输出：false
 //解释："a" 无法匹配 "aa" 整个字符串。
 //
 //
 // 示例 2:
 //
 //
 //输入：s = "aa", p = "a*"
 //输出：true
 //解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 //
 //
 // 示例 3：
 //
 //
 //输入：s = "ab", p = ".*"
 //输出：true
 //解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= s.length <= 20
 // 1 <= p.length <= 30
 // s 只包含从 a-z 的小写字母。
 // p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 // 保证每次出现字符 * 时，前面都匹配到有效的字符
 //
 //
 // Related Topics 递归 字符串 动态规划 👍 3227 👎 0

 **/
/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 O(N*M)
 空间复杂度
 O(N*M)
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
 动态规划:
 如果 p 的第 j 个字符是 *，那么就表示我们可以对 p 的第 j−1 个字符匹配任意自然数次。在匹配 0 次的情况下，我们有.

 匹配 s 末尾的一个字符，将该字符扔掉，而该组合还可以继续进行匹配；
 不匹配字符，将该组合扔掉，不再进行匹配。

 dp[i][j] 表示 S[i] 被 P[j] 匹配的结果。
 dp[i][j] =
 if(S[i] == *)
 if(S[i]==p[j-1])
 dp[i-1][j] or  dp[i][j-2]
 else
 dp[i][j-2]
 else
 dp[i-1][j-1] && S[i]==P[j]


 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:1 ms,击败了100.00% 的Java用户
 内存消耗:40.1 MB,击败了58.68% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution10 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for(int i = 0; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2];
                    if(isMatch(s,p,i,j-1)) {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                } else {
                    if(isMatch(s,p,i,j)) {
                        dp[i][j] = dp[i-1] [j-1];
                    }
                }
            }
        }
        return dp[n][m];
    }

    public boolean isMatch(String s, String p, int i, int j) {
        if(i == 0) {
            return false;
        } else if(p.charAt(j-1) == '.' ){
            return true;
        } else {
            return p.charAt(j-1) == s.charAt(i-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

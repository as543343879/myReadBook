package com.acm.lico.dp;

/**
 通配符匹配:44
 2023-10-15 21:55:36
 //
 // 给你一个输入字符串 (
 // s) 和一个字符模式 (
 // p) ，请你实现一个支持
 // '?' 和
 // '*' 匹配规则的通配符匹配：
 //
 //
 //
 // '?' 可以匹配任何单个字符。
 // '*' 可以匹配任意字符序列（包括空字符序列）。
 //
 //
 //
 //
 // 判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：s = "aa", p = "a"
 //输出：false
 //解释："a" 无法匹配 "aa" 整个字符串。
 //
 //
 // 示例 2：
 //
 //
 //输入：s = "aa", p = "*"
 //输出：true
 //解释：'*' 可以匹配任意字符串。
 //
 //
 // 示例 3：
 //
 //
 //输入：s = "cb", p = "?a"
 //输出：false
 //解释：'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 //
 //
 //
 //
 // 提示：
 //
 //
 // 0 <= s.length, p.length <= 2000
 // s 仅由小写英文字母组成
 // p 仅由小写英文字母、'?' 或 '*' 组成
 //
 //
 // Related Topics 贪心 递归 字符串 动态规划 👍 1097 👎 0

 **/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution44 {

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
     思路： 动态规划 dp[i][j]  表示 Si 和 Pi 的 是否符合匹配。
     Pj != '*' : dp[i][j] = dp[i-1][j-1]
     Pj == '*' if Si == P i - 1 : dp[i][j] = dp[i-1][j] | dp[i][j-1]  else = dp[i][j-1]

     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:14 ms,击败了80.24% 的Java用户
     内存消耗:43.7 MB,击败了48.46% 的Java用户
     */
    public boolean isMatchNew21(String s, String p) {
        if(s == null || p == null  ) {
            return false;
        }
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n + 1][ m + 1];
        dp[0][0] = true;

        char[] charsP = p.toCharArray();
        for(int i = 0; i < p.length(); i ++) {
            if(charsP[i] == '*') {
                dp[0][i + 1] = true;
            } else {
                break;
            }
        }

        char[] charsS = s.toCharArray();

        for(int i = 1; i <= s.length(); i ++) {
            for(int j = 1; j <= p.length(); j ++) {
                char tempP = charsP[j - 1];
                if(tempP == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    if(tempP == '?' || tempP == charsS[i-1] ) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[n][m];
    }
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N)
     空间复杂度 O(N)
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
     动态转移方程思路： 动态规划 dp[i][j] 表示s 长度为i 与 pj 是否匹配
     1， 假如 s[i] == p[i] ， dp[i][j] = dp[i-1][j-1]
     2. 加入 p[j] == ? ，那么dp[i][j] = dp[i-1][j-1]
     3. 加入 p[j] == *. 如果不匹配 dp[i][j] = dp[i][j-1] 如果使用* dp[i][j] = dp[i-1][j]
     思路：
     1. 建立一个 dp[n+1][m+1] 的数组
     2. 建立dp
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:21 ms,击败了70.35% 的Java用户
     内存消耗:43.3 MB,击败了81.46% 的Java用户
     */
    public boolean isMatch(String s, String p) {
        if(p.length() == 1 && p.charAt(0) == '*') {
            return true;
        }
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i = 1; i <=m; i ++) {
            if(p.charAt(i-1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }


        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                char chari = s.charAt(i-1);
                char charj = p.charAt(j - 1);
                if(charj == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else if(charj == '?' || chari == charj){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[n][m];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

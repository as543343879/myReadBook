package com.acm.lico.dp; /**
 * 72 ,编辑距离
 * //给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
 * //
 * // 你可以对一个单词进行如下三种操作：
 * //
 * //
 * // 插入一个字符
 * // 删除一个字符
 * // 替换一个字符
 * //
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：word1 = "horse", word2 = "ros"
 * //输出：3
 * //解释：
 * //horse -> rorse (将 'h' 替换为 'r')
 * //rorse -> rose (删除 'r')
 * //rose -> ros (删除 'e')
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：word1 = "intention", word2 = "execution"
 * //输出：5
 * //解释：
 * //intention -> inention (删除 't')
 * //inention -> enention (将 'i' 替换为 'e')
 * //enention -> exention (将 'n' 替换为 'x')
 * //exention -> exection (将 'n' 替换为 'c')
 * //exection -> execution (插入 'u')
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 0 <= word1.length, word2.length <= 500
 * // word1 和 word2 由小写英文字母组成
 * //
 * //
 * // Related Topics 字符串 动态规划 👍 2739 👎 0
 **/

/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询
 动态规划： 时间  O(N*M) 空间 O(N*M)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 1， 递归，或者动态规划
 递归：
 自顶向上，
 假如 world[i]==world[j]:  reutrn world[i-1][j-1];
 假如 world[i] != world[j]: 对i操作
 删除操作 world[i-1],world[j]
 添加操作 world[i],world[j-1]
 替换操作 wolrd[i-1],world[j-1]
 动态规划：
 自底向上：
 dp[i][j] : 表示 world1 前i个字符 与 world 的前j字符的 的编辑距离。
 if world[i]==world[j] dp[i][j] = dp[i-1][j-1];
 else:
 dp[i][j] = min(dp[i-1][j-1],dp[i-1,j],dp[i,j-1]) + 1;



 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 Time Limit Exceeded
 递归 时间超限。

 > 2023/01/20 18:39:30
 解答成功:
 执行耗时:4 ms,击败了87.79% 的Java用户
 内存消耗:41.8 MB,击败了12.13% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution72 {

    public int minDistance(String word1, String word2) {
        int n1 = word1.length() ;
        int n2 = word2.length() ;
        int[][] dp = new int[n1 + 1][n2 + 1];
        if(n1 * n2 == 0) {
            return n1 + n2;
        }
        for(int i = 0; i < n1 + 1; i ++) {
            dp[i][0] = i;
        }
        for(int j = 0; j < n2 + 1; j ++) {
            dp[0][j] = j;
        }
        for(int i = 1; i < n1 + 1; i ++) {
            for(int j = 1; j < n2 + 1; j ++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int res = Math.min(dp[i-1][j-1], dp[i-1][j]);
                    res = Math.min(dp[i][j-1], res);

                    dp[i][j] = res + 1;
                }
            }
        }
        return dp[n1][n2];
    }
    public int minDistance2(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        else if (word1.charAt(n1 - 1) == word2.charAt(n2 - 1)) {
            return minDistance(word1.substring(0, n1 - 1), word2.substring(0, n2 - 1));
        }
        int res = Math.min(
                minDistance(word1.substring(0, n1 - 1), word2.substring(0, n2 - 1)),
                minDistance(word1.substring(0, n1 - 1), word2)
        );
        res = Math.min(res, minDistance(word1, word2.substring(0, n2 - 1))
        );
        return 1 +  res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

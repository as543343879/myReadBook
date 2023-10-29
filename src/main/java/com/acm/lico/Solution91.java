package com.acm.lico;

/**
 * Solution91 class
 *91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 1 复杂度分析 O(nlogn)
 *
 * 估算问题中复杂度的上限和下限
 * O(1) 一个常量下完成
 * O(n) 一次遍历
 * O(logn) 折半查询
 * O(n^2) 两重嵌套循环查询
 * 2 定位问题
 *
 * 根据问题类型，确定采用何种算法思维。 回溯 + 深度遍历
 * 例如
 * 这个问题是什么类型（排序、查找、最优化）的问题；
 * 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 * 采用哪些数据结构或算法思维，能把这个问题解决。
 * 3 数据操作分析
 *
 * 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 *
 *
 * # 结果
 * 时间超限。
 * @author 谢小平
 * @date 2021/8/4
 */
public class Solution91 {

    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N)
     空间复杂度  O(N)
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
     思路：动态规划
     1. dp[i] = dp[i-1] （Si != 0） + dp[i-2] (Si-1, Si  要小于 26 并且 Si-1 不能等于0) 单个字符 和双个字符
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:39.4 MB,击败了88.82% 的Java用户
     */
    public int numDecodingsNew20(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i ++) {
            if(chars[i-1] != '0') {
                dp[i] = dp[i-1];
            }
            if(i > 1 && chars[i-2] != '0' &&( (chars[i-2] - '0') * 10 + chars[i-1] -'0' < 27)) {
                dp[i] += dp[i-2];
            }

        }
        return dp[n];
    }

    int count = 0;
    final String maxStr = "26";
    public int numDecodings(String s) {
        dfs(s,0);
        return count;
    }

    private void dfs(String s, int i) {
        if(i >= s.length()) {
            if(i == s.length()) {
                count ++;
            }
            return ;
        }
        if(s.charAt(i) == '0') {
            return ;
        }
        dfs(s,i + 1);

        if(i + 2 <= s.length() &&  s.substring(i,i + 2).compareTo(maxStr) <= 0) {
            dfs(s, i + 2);
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution91().numDecodings("111111111111111111111111111111111111111111111"));
    }
}

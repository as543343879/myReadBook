package com.acm.lico.string;

import java.util.Objects;

/**
 最长回文子串:5
 2024-01-06 23:39:47
 //给你一个字符串 s，找到 s 中最长的回文子串。
 //
 // 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：s = "babad"
 //输出："bab"
 //解释："aba" 同样是符合题意的答案。
 //
 //
 // 示例 2：
 //
 //
 //输入：s = "cbbd"
 //输出："bb"
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= s.length <= 1000
 // s 仅由数字和英文字母组成
 //
 //
 // Related Topics 字符串 动态规划 👍 7011 👎 0

 **/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
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
     动态规划：  dp[start][end] = dp[start+1][end -1];
     1. 因为参考了 左下方的位置。 前一行 下一列的位置， 所以应该 根据列来循环， 算出列的位置。  只能一列一列的计算。
     2. 边界情况 j - i  < 3 && Si = Sj  res= true

     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:119 ms,击败了41.63% 的Java用户
     内存消耗:45.1 MB,击败了13.37% 的Java用户
     */
    public String longestPalindrome(String s) {
        if(Objects.isNull(s) || s.length() < 2){
            return s;
        }
        int n = s.length();
        boolean dp[][] = new boolean[n + 1][n + 1];
        dp[0][0] = true;
        for(int i = 0; i <= n; i ++) {
            dp[i][i] = true;
        }
        int max = 1;
        int startIndex = 0;

        for(int end = 1; end <= n; end ++) {
            for(int start = 1; start < end; start ++) {
                if(s.charAt(start-1) == s.charAt(end - 1)) {
                    if(end - start < 3) {
                        dp[start][end] = true;
                    } else {
                        dp[start][end] = dp[start+1][end -1];
                    }

                }

                if(dp[start][end] && ( end - start  + 1 > max ) ) {
                    max =  end - start + 1;
                    startIndex = start;
                }
            }
        }
        if(startIndex != 0) {
            startIndex --;
        }
        return  s.substring(startIndex,startIndex + max );

    }
}
//leetcode submit region end(Prohibit modification and deletion)

package com.acm.lico.dp;

/**
 * Solution32 class
 *
 * @author 格林
 * @date 2022-01-24
 */
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
 动态规划
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
public class Solution32 {
//    public int longestValidParentheses(String s) {
//        int len = s.length();
//        int[][] dp = new int[2][len];
//        dp[0][0] = 0;
//        dp[1][0] = 0;
//        for(int i = 1; i < len; i ++) {
//            if(isRight(s.charAt(i-1),s.charAt(i ) ) ) {
//                dp[0][i] = Math.max(dp[0][i-1] + 2, ;
//                dp[1][i] = dp[1][i-1] + 2;
//                i ++;
//            } else {
//                dp[0][i] = dp[0][i-1] ;
//                dp[1][i] = 0;
//            }
//        }
//        return  0;
//    }
public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for(int i = 1; i < len; i ++) {
            if( s.charAt(i-1) == '(' && s.charAt(i ) == ')'   ) {
                dp[i] = dp[i-1] + 2;
                dp[i + 1] =  dp[i];
                i ++;
            } else if(s.charAt(i-1) == '(' && s.charAt(i ) == '(')  {
                int j = i + 1;
                while (s.charAt(j) == '(') {
                    j++;
                }
                // 左括号长度， 开始于 i - 1
                int iLen  = j - i + 1;
                // 如果全部匹配成功
                int allRight = isAllRight(s, iLen, j + 1);
                if( allRight == 0) {
                    dp[i] = dp[i-1] + 2 * iLen;
                    dp[i + 1] =  dp[i];
                    i = iLen + j + 2;

                } else {
                    dp[i] = 0 ;
                    i = allRight ;
                }

            }
            else {
                dp[i] = 0 ;
            }
        }
        int max = 0;
        for(int k : dp) {
            max = k > max ? k : max;
        }
        return  max;
    }
    private int isAllRight(String str, int len , int startIndex) {
        int allLen = len + startIndex;
        for(int i =startIndex ; i < allLen && i < str.length(); i ++) {
            if(str.charAt(i) != ')') {
                return i;
            }
        }
        return 0;
    }
    private boolean isRight(char start , char end) {
        return start == '(' && end == ')';
    }
    public static void main(String[] args) {
        String str = "()()()()";
        System.out.println(new Solution32().longestValidParentheses(str));

         str = ")(()()()()";
        System.out.println(new Solution32().longestValidParentheses(str));

        str = "()(())";
        System.out.println(new Solution32().longestValidParentheses(str));
        str = "(())";
        System.out.println(new Solution32().longestValidParentheses(str));
        str = "(()";
        System.out.println(new Solution32().longestValidParentheses(str));
    }
}

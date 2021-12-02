package com.datastructure.dp;

import lombok.extern.slf4j.Slf4j;

/**
 * Solution5 class
 *
 * @author 谢小平
 * @date 2021/11/10
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *

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
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果


 */
@Slf4j
public class Solution5 {


    /**
     *
     *  P(i,j) = true 如果 Si->Sj 是回文子串
     *  P(i,j) = false
     *
     *  P(i,j)=true
     *  P(i,i+1)=(Si==Si+1)
     *  P(i,j)=true j-i + 1的最大值。
     *
     * @param s
     * @return
     */
    public String longestPalindrome_dp(String s) {
        int strLen = s.length();
        if(strLen < 2) {
            return s;
        }
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[strLen][strLen];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < strLen; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;
        for(int len = 2; len <= strLen; len ++) {
            for(int left = 0;  left < strLen ; left ++) {
                int right = left + len - 1;
                if(right >= strLen) {
                    break;
                }
                if(s.charAt(left) != s.charAt(right)) {
                    dp[left][right] = false;
                } else {
                    // 121 0 2
                    if(right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left+1][right-1];
                    }
                }
                if(dp[left][right] && maxLen < (right- left + 1) ) {
                    maxLen = right - left + 1;
                    begin = left;

                }


            }

        }
        return s.substring(begin,begin+maxLen);
    }


    /**
     * 暴力求解时间超限
     * @param s
     * @return
     */
    public String longestPalindrome_violence(String s) {
        if(s == null || s.equals("")) {
            return "";
        }
        int len = s.length();
        int max = 0;
        int begin = 0;
        int end = 0;
        for(int i = 0; i < len - 1; i ++) {
            for(int j = len - 1; j >= 0; j --) {
                if(i >= j) {
                    break;
                }
                if(isRepern(s,i,j)) {
                    int maxLen = j - i + 1;
                    if( maxLen > max ) {
                        max = maxLen;
                        begin = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(begin,end + 1);
    }

    public boolean isRepern(String s, int begin, int end) {
        int i = begin,j = end;
      while (begin < end) {
          if (s.charAt(begin) != s.charAt(end)) {
              return false;
          }
          begin ++;
          end -- ;
      }
//      log.info("begin={}`end={}`res={}",i,j,s.substring(i,j + 1));
        return true;
    }



    public static void main(String[] args) {
        String str = "cbbd";
         System.out.println(new Solution5().longestPalindrome_dp(str));
    }
}

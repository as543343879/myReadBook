package com.acm.lico.dp; /**
 5 ,最长回文子串
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
 // Related Topics 字符串 动态规划 👍 6199 👎 0

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
 自己思路：
 时间复杂度 O(N) 错误 应该是 O(N ^ 2)
 空间复杂度 O(1)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 枚举所有回文中心， 一共有 2*n -1个
 left = i / 2 , right = i / 2 + i % 2;


 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 官方跟自己相同的思路：
 解答成功:
 执行耗时:18 ms,击败了76.00% 的Java用户
 内存消耗:41.3 MB,击败了81.55% 的Java用户

 自己思路：
 解答成功:
 执行耗时:21 ms,击败了65.60% 的Java用户
 内存消耗:41.4 MB,击败了78.30% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度 O(N^2)
     空间复杂度 O(1）
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
     思路：中心扩散法
     1. 枚举[0,n-1) 的 中心节点 i，
     2. 同时判断 （i,i） 和 （i,i+1） 的中心节点
     3. 判断回文子串长度， 如果长度 大于max。 则记录下标。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:8 ms,击败了94.59% 的Java用户
     内存消耗:40.2 MB,击败了78.05% 的Java用户
     */
    public String longestPalindrome_new01(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int index = 0;
        for(int i = 0; i < s.length() - 1; i ++) {
            int len1 = getLen(chars,i,i);
            int len2 = getLen(chars,i,i+1);
            int len = Math.max(len1,len2);
            if(len > maxLen) {
                maxLen = len;
                index = i;
            }
        }
        return s.substring(index -  (maxLen- 1) / 2 , index + maxLen / 2 + 1);

    }
    private int getLen( char[] chars, int left, int right) {
        while (left >= 0 && right <= chars.length - 1 && chars[left] == chars[right]) {
            left --;
            right ++;
        }
        //  012345
        return right - left - 1;
    }

    public String longestPalindrome_official(String s) {
        if(s == null || s.length() < 0 )
            return null;
        int max = 0;
        int start = 0;
        for(int i = 0; i < s.length() ; i ++) {
            int jiLen = maxPalindrome(s, i, i);
            int ouLen = maxPalindrome(s, i, i + 1);
            int t = Math.max(jiLen, ouLen);
            if(max < t) {
                max = t;
                start = i - (max - 1) / 2;
            }
        }
        return s.substring(start,max  + start);
    }

    private int maxPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return right - left - 1;
    }

    /**
     * 自己思路
     * @param s
     * @return
     */
    public String longestPalindrome_me(String s) {
        if(s == null) {
            return s;
        }
        int total = s.length() * 2 - 1;
        int max = 1;
        int start = 0;
        int end = 0;
        for(int i = 0; i < total; i ++) {
            int left = i  / 2 ;
            int right = left + i % 2;
            int tempMax = s.charAt(left) == s.charAt(right)  ? left == right ? 1 : 2 : 0;
            if(tempMax > 0) {
                while (left >= 1  && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(right + 1)   ) {
                    left --;
                    right ++;
                    tempMax += 2;
                }
                if(tempMax > max) {
                    start = left  ;
                    end = right;
                    max = tempMax;
                }
            }
        }
        return s.substring(start,end + 1) ;
    }

    /**
     * 修改 没有完成 ， 替换调 i + 1
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s == null) {
            return s;
        }
        int total = s.length() * 2 - 1;
        int max = 2;
        int start = 0;
        int end = 0;
        for(int i = 0; i < total; i ++) {
            int left = i  / 2 ;
            int right = left + i % 2;
            int tempMax = 0 ;
            if(tempMax > 0) {
                while (left >= 0  && right < s.length()  && s.charAt(left ) == s.charAt(right + 1)   ) {
                    left --;
                    right ++;
                    tempMax += 2;
                }
                if(tempMax >= max) {
                    start = left  ;
                    end = right;
                    max = tempMax;
                }
            }
        }
        return s.substring(start,end + 1) ;
    }
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

}
//leetcode submit region end(Prohibit modification and deletion)

package com.acm.lico.string; /**
151 ,反转字符串中的单词
//给你一个字符串 s ，请你反转字符串中 单词 的顺序。 
//
// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。 
//
// 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。 
//
// 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 
//输入：s = "  hello world  "
//输出："world hello"
//解释：反转后的字符串中不能存在前导空格和尾随空格。
// 
//
// 示例 3： 
//
// 
//输入：s = "a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。 
//
// Related Topics 双指针 字符串 👍 685 👎 0

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
 reverseWords:
 时间复杂度
 O(N)
 空间复杂度
 O(1)
 2 定位问题
根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 模拟题
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果

 reverseWords:
 解答成功:
 执行耗时:8 ms,击败了35.87% 的Java用户
 内存消耗:42.1 MB,击败了5.03% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution151 {
    public String reverseWords(String s) {
        if(s == null) {
            return null;
        }

        int n = s.length();
        String res = null;
        boolean isStart = true;
        for(int i = 0; i < n; i ++ ) {
            if (s.charAt(i) == ' ') {
                i++;
                while (i<n && s.charAt(i) == ' ') {
                    i++;
                }
                i --;
            } else {
                int start = i;
                while (i < n && s.charAt(i) != ' '){
                    i ++;
                }
                if(isStart) {
                    res =  s.substring(start,i) ;
                    isStart = false;
                } else {
                    res =   s.substring(start,i)  + " "+ res;
                }

                i--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution151().reverseWords("  the sky is blue  "));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

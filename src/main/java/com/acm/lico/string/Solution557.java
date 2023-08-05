package com.acm.lico.string; /**
 557 ,反转字符串中的单词 III
 //给定一个字符串
 // s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：s = "Let's take LeetCode contest"
 //输出："s'teL ekat edoCteeL tsetnoc"
 //
 //
 // 示例 2:
 //
 //
 //输入： s = "God Ding"
 //输出："doG gniD"
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= s.length <= 5 * 10⁴
 //
 // s 包含可打印的 ASCII 字符。
 //
 // s 不包含任何开头或结尾空格。
 //
 // s 里 至少 有一个词。
 //
 // s 中的所有单词都用一个空格隔开。
 //
 //
 // Related Topics 双指针 字符串 👍 549 👎 0

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
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 根据空格或者最后一个节点， 找到其实
 自己思路：
 解答成功:
 执行耗时:3 ms,击败了90.68% 的Java用户
 内存消耗:43.1 MB,击败了5.08% 的Java用户

 自己思路：
 解答成功:
 执行耗时:3 ms,击败了90.68% 的Java用户
 内存消耗:43.4 MB,击败了5.08% 的Java用户

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution557 {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int start=0,end;

        while (chars[start] == ' '){
            start++;
        }

        for(int i = 0; i < chars.length; i ++) {
            if(chars[i] != ' ' && start == -1 ) {
                start = i;
            } else if(chars[i] == ' ' &&  start != -1) {
                end = i - 1;
                reverseStringOld(chars, start, end);
                start = -1;
            }
        }
        if(start != -1) {
            end = s.length() - 1;
            reverseStringOld(chars, start, end);
        }
//        if(chars.length)
        return new String(chars);
    }
//    public void reverseStringOld(char[] s, int left, int right) {
//
//        char t;
//        while (left < right) {
//            t = s[left];
//            s[left] = s[right];
//            s[right] = t;
//            left ++;
//            right --;
//        }
//    }

    public void reverseStringOld(char[] s, int start, int end) {
        if(start >= end) {
            return;
        }
        int middle = (end + start -1) / 2;
        for(int i = start; i <= middle; i ++) {
            char t = s[i];

            s[i] = s[end - i + start];
            s[end - i + start] = t;
        }
    }


    public String reverseWords2(String s) {
        int len = s.length();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < len; ) {
            if (s.charAt(i) == ' ') {
                str.append(' ');
                i++;
            } else {
                int start = i;
                while (i < len && s.charAt(i) != ' ') {
                    i++;
                }
                String substring = s.substring(start, i);
                StringBuffer sb = new StringBuffer(substring);
                sb.reverse();
                str.append(sb);
            }
        }
        return str.toString();
    }

    /**
     *  解答成功:
     *  执行耗时:4 ms,击败了79.37% 的Java用户
     *  内存消耗:42.3 MB,击败了19.34% 的Java用户
     * @param s
     * @return
     */
    public String reverseWordsOld(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }


}
//leetcode submit region end(Prohibit modification and deletion)

package com.acm.lico.stack;

import java.util.Deque;
import java.util.LinkedList;


/**
 * https://leetcode.cn/problems/decode-string/description/
 * 394. 字符串解码
 * 中等
 * 1.3K
 * 相关企业
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限

 decodeString：
 时间复杂度 O(N)
 空间复杂度 O(N)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询

 2 定位问题
 栈
 注意正反顺序
根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 1 ms击败75.44%内存
 39.3 MB击败77.26%
 */
/**
 * Solution394 class
 *
 * @author 格林
 * @date 2022-11-07
 */
public class Solution394 {
    public static void main(String[] args) {
//        System.out.println(new Solution394().decodeString("3[a]2[bc]"));
        System.out.println(new Solution394().decodeString("3[a2[c]]"));
//        System.out.println(new Solution394().decodeString("2[abc]3[cd]ef"));
    }
    public String decodeString(String s) {
        if(s == null) {
            return null;
        }
        LinkedList<String> queue = new LinkedList<>();
        int n = s.length();
        int index = 0;
        while (index < n) {
            char c = s.charAt(index);
            // 加入是数字
            if(Character.isDigit(c)) {
                int nextIndex = index;
                while (Character.isDigit(s.charAt(nextIndex))  ) {
                    nextIndex ++;
                }
                String num = s.substring(index, nextIndex);
                queue.addLast(num);
                index = nextIndex;
                // 假如是小写字母
            } else if(Character.isLetter(c)) {
                int nextIndex = index;
                while (nextIndex < n && Character.isLetter(s.charAt(nextIndex)) ) {
                    nextIndex ++;
                }
                String letterStr = s.substring(index, nextIndex);
                queue.addLast(letterStr);
                index = nextIndex;
                // 假如是左括号
            } else if(c == '[') {
                queue.addLast(String.valueOf(c));
                index ++;
                // 假如是右括号
            } else {
                String t = queue.pollLast();
//                StringBuilder subStringBuilder = new StringBuilder();
                StringBuilder subStringBuilder = new StringBuilder();
                while ( !"[".equals(t)) {
                    subStringBuilder.insert(0, t);
//                    subStringBuilder.append(t);
                    t = queue.pollLast();
                }
                int num = Integer.parseInt(queue.pollLast());
                num --;
                t = subStringBuilder.toString();
                for(int i = 0; i < num ; i ++) {
                    subStringBuilder.append(t);
                }
                queue.addLast(subStringBuilder.toString());
                index++;
            }
        }
        StringBuffer res = new StringBuffer();
        for(String str : queue) {
            res.append(str);
        }
        return res.toString();
    }


    /**
     * 太复杂了
     * @param s
     * @return
     */
    public String decodeString3(String s) {

        int startIndex = s.indexOf("[");
        if(startIndex == -1) {
            return s;
        }
        startIndex --;
        StringBuilder res = new StringBuilder();
        res.append(s.substring(0,startIndex));


        Deque<String> strSatck = new LinkedList<>();
        Deque<Integer> numSatck = new LinkedList<>();
        String endStr = "";
        for(int i = startIndex; i < s.length(); i ++) {
            // 如果不是小写字母
            char c = s.charAt(i);
            if(!Character.isLowerCase(c)) {
                if(Character.isDigit(c)) {
                    numSatck.push(c-'0');
                    i++;
                    int j = i;
                    while ( Character.isLowerCase(s.charAt(j)) ) {
                        j ++;
                    }
                    if(i != j) {
                        strSatck.push(s.substring(i,j));
                    }
                    i =  j - 1;
                    // 说明是 ] 符号
                } else {
                    String subStr = strSatck.pollLast();
                    Integer count = numSatck.pollLast() - 1;
                    for(int k = 0; k < count ; k ++) {
                        subStr += subStr;
                    }


                    strSatck.push(subStr);
                }

            } else {
                endStr = s.substring(i);
                break;
            }
        }
        res.append(strSatck.peek()).append(endStr);

        return res.toString();

    }
    /**
     * 错误
     * @param s
     * @return
     */
    public String decodeString2(String s) {
        String[] split = s.split("]");
        StringBuilder res = new StringBuilder();
        for(String t : split) {
            res.append(recurrence(t + "]"));
        }
        return res.toString();
    }
    public String  recurrence(String s) {
        int index = s.indexOf("[");
        if(index == -1) {
            return s;
        }
        int n = s.length();
        int endIndex = s.lastIndexOf("]");
        int sum = Integer.valueOf(s.charAt(index-1) - '0');

        String startStr = "";
        if(index > 1) {
            startStr = s.substring(0,index -1);
        }

        for(int i = 0; i < sum; i ++) {
            String subS = s.substring(index + 1, endIndex  +1 );
            startStr += recurrence(subS);
        }

        if(n -1 > endIndex ) {
            startStr += s.substring(endIndex - 1);
        }

        return startStr;

    }
}

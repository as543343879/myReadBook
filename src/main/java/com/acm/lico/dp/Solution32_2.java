package com.acm.lico.dp;

/**
 * Solution32_2 class
 *
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @author 格林
 * @date 2022-01-25
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 O(n)
 空间复杂度
O(n)
 2 定位问题
 栈 最底下一个元素 表示 括号匹配被它 隔断。
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
public class Solution32_2 {
    public int longestValidParentheses_error(String s) {
        Deque<Character> stack = new  LinkedList<Character>();
//        stack.push('1');
        int maxLen = 0;
        Character cLeft = '(';
        Character cRight = ')';
        int len = 0;
        for(int i =0; i < s.length(); i ++) {
            if(s.charAt(i)== '(') {
                stack.push(cLeft);
            } else {
                // 格式正确且连续 ()(()
                if(stack.isEmpty()) {
                    len = 0;
                } else  {
                    stack.pop();
                    len += 2;
                    maxLen = Math.max(len,maxLen);
                }

            }
        }
        return maxLen;
    }


    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new  LinkedList();
//        stack.push('1');
        int maxLen = 0;
        Character cLeft = '(';
        Character cRight = ')';
        stack.push(-1);
        for(int i =0; i < s.length(); i ++) {
            if(s.charAt(i)== '(') {
                stack.push(i);
            } else {
//                stack.pop(); if (stack.isEmpty()) { stack.push(i); } else { maxans = Math.max(maxans, i - stack.peek()); }
                // 格式正确且连续 )(()()()()
                 stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                    // 不空
                } else  {
                    maxLen = Math.max(maxLen, i -  stack.peek() );
                }

            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "()()()()";
        System.out.println(new Solution32_2().longestValidParentheses(str));

        str = ")(()()()()";
        System.out.println(new Solution32_2().longestValidParentheses(str));

        str = "()(())";
        System.out.println(new Solution32_2().longestValidParentheses(str));
        str = "(())";
        System.out.println(new Solution32_2().longestValidParentheses(str));
        str = "(()";
        System.out.println(new Solution32_2().longestValidParentheses(str));

        str = "(()())";
        System.out.println(new Solution32_2().longestValidParentheses(str));

        str = "()(()";
        System.out.println(new Solution32_2().longestValidParentheses(str));


        str = "()(()(";
        System.out.println(new Solution32_2().longestValidParentheses(str));
    }
}

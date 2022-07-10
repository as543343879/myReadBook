package com.acm.lico.doNotKnow;

/**
 * Solution227 class
 * https://leetcode.cn/problems/basic-calculator-ii/
 *227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 *
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 格林
 * @date 2022-07-09
 */

import com.acm.lico.Solution1;

import java.util.LinkedList;
import java.util.Stack;

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
 先把 乘除 优先计算。 再算加减
 栈 + 队列。
 从左往右边计算，需要考虑到队列。
根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 17 ms , 在所有 Java 提交中击败了 46.52% 的用户
 内存消耗： 44.4 MB , 在所有 Java 提交中击败了 18.32% 的用户
 通过测试用例： 109 / 109
 */
public class Solution227 {

    public int calculate(String s) {
        Stack<Integer> numberStack = new Stack<Integer>();
        Stack<Character> operateStack = new Stack<>();
        for(int i = 0; i < s.length(); i ++) {
             if(isOperate(s.charAt(i))) {
                 if (s.charAt(i) == '/') {
                     while (!Character.isDigit(s.charAt(++i))) {

                     }
                     int res = 0;
                     while (i < s.length() && Character.isDigit(s.charAt(i))) {
                         res = res * 10 + s.charAt(i) - '0';
                         ++i;
                     }
                     i --;

                     res = numberStack.pop() / res;
                     numberStack.push(res);
                 } else if (s.charAt(i) == '*') {
                     while (!Character.isDigit(s.charAt(++i))) {

                     }
                     int res = 0;
                     while (i < s.length() && Character.isDigit(s.charAt(i))) {
                         res = res * 10 + s.charAt(i) - '0';
                         ++i;
                     }
                     i --;
                      res = numberStack.pop() * res;
                     numberStack.push(res);
                 } else {
                     operateStack.push(s.charAt(i));
                 }
             } else if (s.charAt(i) != ' ') {
                 int res = 0;
                 while (i < s.length() && Character.isDigit(s.charAt(i))) {
                     res = res * 10 + s.charAt(i) - '0';
                     ++i;
                 }
                 i --;
                 numberStack.push(res);
             }

        }
        int numberStackIndex = 1;
        int res = numberStack.get(0);
        for(Character t: operateStack) {
            int second = numberStack.get(numberStackIndex++) ;
            if (t =='+') {
                res += second;
            } else {
                res -= second;
            }

        }
//        while (!operateStack.isEmpty()) {
//            operateStack.peek()
//            Character operate = operateStack.pollLast();
//            int  first = numberStack.pollLast() ;
//            int second = numberStack.pollLast() ;
//            if (operate =='+') {
//                numberStack.addFirst(first + second);
//            } else {
//                numberStack.addFirst(first - second);
//            }
//        }
        return res;
    }

    private boolean isOperate(char c) {
        if(c == '+' || c == '-' || c == '/' || c == '*') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution227().calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}

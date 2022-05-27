package com.acm.lico.doNotKnow;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * Solution150 class
 *150. 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 注意 两个整数之间的除法只保留整数部分。
 *
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 *
 *
 * 示例 1：
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * @author 谢小平
 * @date 2022/5/27
 */
public class Solution150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> symbolStack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("*");
        set.add("/");
        set.add("+");
        set.add("-");

//        for(String key : tokens) {
//            if (set.contains(key)) {
//                symbolStack.push(key);
//            } else {
//                numberStack.push(Integer.valueOf(key));
//            }
//        }
        int i = 0;
        while (i < tokens.length) {
             if((!symbolStack.isEmpty()) ) {
                 int int2 = numberStack.pop();
                 int int1 = numberStack.pop();
                 int res = compute(int1,int2,symbolStack.pop());
                 numberStack.push(res);
             } else {
                 while ((symbolStack.isEmpty() || numberStack.size() < 2) ) {
                    i ++;
                    if(i >= tokens.length) {
                        break;
                    }
                     String key =  tokens[i];
                   if (set.contains(key)) {
                        symbolStack.push(key);
                    } else {
                        numberStack.push(Integer.valueOf(key));
                    }
                 }
             }

        }
        return numberStack.peek();
    }
    public int compute(int int1, int int2, String computeSymbol) {
//        System.out.println(int1 + computeSymbol + int2);
        int resReturn = 0;
        switch (computeSymbol) {
            case "+" :
                resReturn = int1 + int2;
                break;
            case "-":
                resReturn = int1 - int2;
                break;
            case "*":
                resReturn = int1 * int2;
                break;
            case "/":
                resReturn  = int1 / int2;
                break;
            default:
        }
        return resReturn;
    }

    public static void main(String[] args) {
        String tokens[] = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new Solution150().evalRPN(tokens));
    }
}

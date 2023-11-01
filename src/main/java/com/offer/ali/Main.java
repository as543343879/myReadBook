package com.offer.ali;

import cn.hutool.core.util.NumberUtil;
import org.apache.commons.lang3.CharUtils;

import java.util.Stack;

/**
 * Main class
 *
 * @author 格林
 * @date 2023-10-31
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().code("3[a]2[bc]"));
        System.out.println(new Main().code("3[a2[c]]"));
        System.out.println(new Main().code("abc3[cd]xyz"));


    }
    private String code(String str) {

        Stack<String> stack = new Stack<>();
        char[] strChars = str.toCharArray();
        for(int i = 0; i < strChars.length; i ++) {
            if(strChars[i] >= '0' && strChars[i] <= '9') {
                int j = i;
                while ( j < strChars.length  && strChars[j] >= '0' && strChars[j] <= '9' ) {
                    j++;
                }
                stack.push(str.substring(i,j));
                i = j;
            } else if(CharUtils.isAsciiAlpha(strChars[i])) {
                int j = i;
                while (j < strChars.length && CharUtils.isAsciiAlpha(strChars[j])) {
                    j++;
                }
                stack.push(str.substring(i, j));
                i = j;
                i --;
            } else if(strChars[i] == ']') {
                StringBuilder tempOneStr = new StringBuilder();
                while (!NumberUtil.isNumber(stack.peek())) {
                    tempOneStr.insert(0, stack.pop());
                }

                int count = Integer.valueOf(stack.pop());
                StringBuilder tempStrSb = new StringBuilder();
                for(int k = 0; k < count; k ++) {
                    tempStrSb.append(tempOneStr);
                }
                stack.push(tempStrSb.toString());
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0,stack.pop());
        }

        return  res.toString();

    }


}

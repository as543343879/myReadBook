package com.acm.lico;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Solution20 class
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author 格林
 * @date 2021-06-27
 */
public class Solution20 {
    static Map<Character,Character> characterMap = new HashMap<>(6);
    static {
        characterMap.put(')','(');
        characterMap.put('}','{');
        characterMap.put(']','[');
    }
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> charStack = new Stack<>();
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if( c == '(' || c == '{' || c == '[') {
                charStack.push(c);
            }  else {
                if(charStack.empty()) {
                    return false;
                }
                if(!characterMap.get(c).equals(charStack.pop())) {
                    return false;
                }
            }
        }

        return charStack.empty();
    }
}

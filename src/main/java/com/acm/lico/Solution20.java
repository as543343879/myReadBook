package com.acm.lico; /**
 20 ,有效的括号
 //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 //
 // 有效字符串需满足：
 //
 //
 // 左括号必须用相同类型的右括号闭合。
 // 左括号必须以正确的顺序闭合。
 // 每个右括号都有一个对应的相同类型的左括号。
 //
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：s = "()"
 //输出：true
 //
 //
 // 示例 2：
 //
 //
 //输入：s = "()[]{}"
 //输出：true
 //
 //
 // 示例 3：
 //
 //
 //输入：s = "(]"
 //输出：false
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= s.length <= 10⁴
 // s 仅由括号 '()[]{}' 组成
 //
 //
 // Related Topics 栈 字符串 👍 3794 👎 0

 **/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
 自己思路：
 时间复杂度 O(N)
 空间复杂度 O(N)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 左括号 入队， 右括号出队。 并且看能不能抵消。 最后看栈是否为空
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:1 ms,击败了98.57% 的Java用户
 内存消耗:39.5 MB,击败了65.87% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution20 {

    static Map<Character,Character> characterMap = new HashMap<>(6);
    static {
        characterMap.put(')','(');
        characterMap.put('}','{');
        characterMap.put(']','[');
    }

    /**
     * 旧的刷题记录
     * @param s
     * @return
     */
    public boolean isValidOld(String s) {
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


    public boolean isValid(String s) {
        if(s ==null || s.length() == 0) {
            return false;
        }
        LinkedList<Character> list = new LinkedList();
        char[] sChars = s.toCharArray();
        for(char t: sChars) {
            if(t == '[' || t == '(' || t == '{') {
                list.push(t);
            } else {
                if(list.isEmpty()) {
                    return false;
                }
                if(t == ')') {
                    Character pop = list.pop();
                    if( pop.charValue() != '(') {
                        return false;
                    }
                } else if( t== ']') {
                    Character pop = list.pop();
                    if(pop.charValue() != '[') {
                        return false;
                    }
                } else if( t== '}') {
                    Character pop = list.pop();
                    if(pop.charValue() != '{') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return list.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

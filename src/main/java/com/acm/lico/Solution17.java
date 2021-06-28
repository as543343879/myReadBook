package com.acm.lico;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution17 class
 * 17. 电话号码的字母组合
 *给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-27
 */
public class Solution17 {
    static  char[][] map = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        dfs(list,digits,0,new StringBuilder());
        return list;
    }

    private void dfs(List<String> list,String digits, int count, StringBuilder stringBuilder) {
        if(count == digits.length() ) {
            list.add(stringBuilder.toString());
            return ;
        }
        char[]  chars = map[digits.charAt(count)-'0'-2];
        for(int i = 0; i < chars.length; i ++) {
            stringBuilder.append(chars[i]);
            dfs(list,digits,count+1,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
       System.out.println( new Solution17().letterCombinations("23").toString());
    }
}

package com.acm.lico;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution22 class
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-27
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> stringList = new ArrayList<>();
        if(n == 0)
            return stringList;
        dfs(stringList,new StringBuilder(),0,0,n);
        return stringList;
    }

    /**
     *
     * @param stringList
     * @param stringBuilder
     * @param leftCount 左括号数量  leftCount <= n
     * @param rightCount 右括号数量  rightCount <= leftCount
     * @param n
     */
    private void dfs(List<String> stringList, StringBuilder stringBuilder, int leftCount, int rightCount, int n) {
        if(leftCount == n && rightCount == n) {
            stringList.add(stringBuilder.toString());
        }
        if(leftCount < n) {
            stringBuilder.append('(');
            dfs(stringList,stringBuilder,leftCount +  1,rightCount,n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if(rightCount < leftCount) {
            stringBuilder.append(')');
            dfs(stringList,stringBuilder,leftCount ,rightCount + 1,n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

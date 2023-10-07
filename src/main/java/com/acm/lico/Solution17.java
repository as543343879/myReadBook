package com.acm.lico;

import java.util.*;

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


    static Map<Character, List<Character>> map2 = new HashMap<>();
    static {
        map2.put('2', Arrays.asList('a', 'b', 'c'));
        map2.put('3', Arrays.asList('d', 'e', 'f'));
        map2.put('4', Arrays.asList('g', 'h', 'i'));
        map2.put('5', Arrays.asList('j', 'k', 'l'));
        map2.put('6', Arrays.asList('m', 'n', 'o'));
        map2.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map2.put('8', Arrays.asList('t', 'u', 'v'));
        map2.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }
    List<String>  res= new ArrayList<>();
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(3^N) 细节错误 O( 3 ^ N * 4^M)  N M 表示 保护3个字母和 4个字母的个数
     空间复杂度 O(LogN) 错误 O(N + M) 空间复杂度 主要是 递归的最大层次 就是 这个
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
     思路：
     1. 先建立一个字典， 映射字符与字母的关系
     2. 便利输入字符，然后回溯。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:1 ms,击败了46.70% 的Java用户
     内存消耗:39.9 MB,击败了71.59% 的Java用户
     */
    public List<String> letterCombinationsNew2(String digits) {
        dfs(digits, 0, new StringBuilder());
        return res;
    }

    public void dfs(String digits,int index,  StringBuilder tempStr) {
        if( index == digits.length()) {
            if(tempStr.length() > 0) {
                res.add(tempStr.toString());
            }
            return ;
        }
        List<Character> letters = map2.get(digits.charAt(index));
        for(int i = 0 ; i < letters.size(); i ++) {
            tempStr.append(letters.get(i));
            dfs(digits, index + 1, tempStr);
            // 这里不需要提前计算长度，因为 后面回缩 长度 会缩回来。
            tempStr.deleteCharAt(tempStr.length() - 1);
        }
    }
}

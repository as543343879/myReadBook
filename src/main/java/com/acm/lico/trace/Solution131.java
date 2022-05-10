package com.acm.lico.trace;

import java.util.*;

/**
 * Solution131 class
 *
 * @author 谢小平
 * @date 2022/5/9
 */

/**
 131. 分割回文串
 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

 回文串 是正着读和反着读都一样的字符串。



 示例 1：

 输入：s = "aab"
 输出：[["a","a","b"],["aa","b"]]

 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。
    回溯。

    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果：
 执行用时： 8 ms , 在所有 Java 提交中击败了 58.94% 的用户
 内存消耗： 55.7 MB , 在所有 Java 提交中击败了 11.49% 的用户
 通过测试用例： 32 / 32
 */
public class Solution131 {
    int n;
    List<List<String>> res = new LinkedList<>();
    LinkedList<String> tempRes = new LinkedList<>();
    boolean [][]fill;
    public List<List<String>> partition(String s) {
        n = s.length();
        fill = new boolean[n][n];
        for(int i = 0; i < n; i ++) {
            Arrays.fill(fill[i], true);
        }
        for(int i = n-1; i >= 0; i --) {
            for(int j = i + 1; j < n; j ++) {
                fill[i][j] = (s.charAt(i) == s.charAt(j)) && fill[i+1][j-1];
            }
        }
        dfs(s,0);
        return res;
    }

    public void dfs(String s, int start) {
        if (start == n) {
            res.add(new ArrayList<>(tempRes));
            return ;
        }
        for(int i = start; i < n; i ++) {
            if(fill[start][i]) {
                String temp = s.substring(start, i + 1);
                tempRes.add(temp);
                dfs(s,i +1);
                tempRes.removeLast();
            }
        }
    }
    public static void main(String[] args) {
        Solution131 t =  new Solution131();
        System.out.println(t.partition("xxabb"));
        for (List<String> temp: t.res) {
            System.out.println(Arrays.toString(temp.toArray()));
        }
    }

//    public List<List<String>> partition(String s) {
//        int n = s.length();
//        List<List<String>> res = new LinkedList<>();
//
//        int start = 0;
//        while (start < n) {
//            List<String> subRes = dfs(s, 0);
//            List<String> tempRes = new LinkedList<>();
//            for(int i = 0; i < subRes.size(); i ++) {
//                String subStr = subRes.get(i);
//                tempRes.add(subStr);
//                int index = subStr.length();
//                while (index < n) {
//                    List<String> inSubRes = dfs(s, index);
//                    for(int k = 0; k < inSubRes.size(); k ++) {
//                        tempRes.add(inSubRes.get(k));
//                    }
//                }
//
//            }
//        }
//
//
//
//        return res;
//    }

//    public List<String> dfs(String s, int start_index) {
//        List<String> res = new LinkedList<>();
//        res.add(String.valueOf(s.charAt(start_index)));
//        int n = s.length();
//        for(int i = start_index; i < n; i ++) {
//            for(int j = i + 1; j < n; j ++) {
//                if(isRight(s, i, j)){
//                    res.add(s.substring(i,j +1));
//                    i = j +1;
//                }
//            }
//        }
//
//        return res;
//    }
//
//    public boolean isRight(String s, int start, int end) {
//        boolean res = true;
//        if (start > end) {
//            return false;
//        }
//        while (start < end) {
//            if(s.charAt(start) != s.charAt(end)) {
//                return false;
//            }
//            start ++;
//            end --;
//        }
//
//        return res;
//
//    }

}

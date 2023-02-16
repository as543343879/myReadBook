package com.acm.lico.recall; /**
 301 ,删除无效的括号
 //给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 //
 // 返回所有可能的结果。答案可以按 任意顺序 返回。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：s = "()())()"
 //输出：["(())()","()()()"]
 //
 //
 // 示例 2：
 //
 //
 //输入：s = "(a)())()"
 //输出：["(a())()","(a)()()"]
 //
 //
 // 示例 3：
 //
 //
 //输入：s = ")("
 //输出：[""]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= s.length <= 25
 // s 由小写英文字母以及括号 '(' 和 ')' 组成
 // s 中至多含 20 个括号
 //
 //
 // Related Topics 广度优先搜索 字符串 回溯 👍 793 👎 0

 **/

import java.util.*;

/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询

 官网思路：
 时间复杂度 NlogN
 空间复杂度 O(N)

 时间复杂度 N * 2^n  , 递归的次数 * 每次递归中的操作次数
 空间复杂度 O(N^2)   ,
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。

 官网思路：
 lremove rremove  表示左右 分别要移除的 括号个数。
 lremove 维护碰到左括号 加1
 rremove 维护 假如 lremove 大于0 ，lremove-- ，假如 lremove == 0，rremove ++
 然后回溯 删除某个 左括号 或者 右括号
 当 lremove == 0 &&  lremove == 0 的时候 校验是否正常
 当 len < rremove + lremove 直接return


 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:4 ms,击败了64.27% 的Java用户
 内存消耗:41.2 MB,击败了88.20% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution301 {
    Set<String> res = new LinkedHashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int lRemove = 0;
        int rRemove = 0;
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == '(') {
                lRemove ++;
            } else if(s.charAt(i) == ')') {
                if(lRemove > 0) {
                    lRemove --;
                } else {
                    rRemove ++;
                }
            }
        }
        help(s,0,lRemove,rRemove);
        if(res.isEmpty()) {
            res.add("");
        }
        return new ArrayList<>(res);
    }
    public void help(String s, int start,  int lRemove, int rRemove) {
        if(lRemove == 0 && rRemove == 0 ) {
            if (vail(s)) {
                res.add(s);
            }

        }
        if (s.length() < lRemove + rRemove) {
            return;
        }

        for(int i = start; i < s.length(); i ++) {
            if(i != start &&  s.charAt(i) == s.charAt(i-1)) {
                continue;
            }

            if (s.length() - i < lRemove + rRemove) {
                return;
            }
            if( lRemove > 0 && s.charAt(i) == '(') {
                help(s.substring(0,i) + s.substring(i + 1), i , lRemove - 1, rRemove);
            }

            if(rRemove > 0 && s.charAt(i) == ')') {
                help(s.substring(0,i) + s.substring(i + 1), i , lRemove, rRemove - 1);
            }
        }

    }

    public boolean vail(String s) {
        int lRemove = 0;
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == '(') {
                lRemove ++;
            } else if(s.charAt(i) == ')') {
                lRemove --;
                if(lRemove < 0) {
                    return false;
                }
            }
        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

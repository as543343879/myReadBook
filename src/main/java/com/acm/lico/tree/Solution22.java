package com.acm.lico.tree; /**
 22 ,括号生成
 //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：n = 3
 //输出：["((()))","(()())","(())()","()(())","()()()"]
 //
 //
 // 示例 2：
 //
 //
 //输入：n = 1
 //输出：["()"]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= n <= 8
 //
 //
 // Related Topics 字符串 动态规划 回溯 👍 3264 👎 0

 **/

import java.util.ArrayList;
import java.util.List;

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
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(log N ) 2^2n * n = O(n)
     空间复杂度  O(log N ) 2n = O(n)
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
     自己思路：
     1. 编写一个方法，添加括号， 递归调用， 分为 加左括号和右括号两种
     2. 记录左右括号个数，来判断是否 是有效括号
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:1 ms,击败了74.98% 的Java用户
     内存消耗:42.6 MB,击败了15.09% 的Java用户
     */

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 1,0, "(");
        return res;
    }
    public void dfs(int n, int  left, int right, String str){
        if(str.length() == 2*n){
            res.add(new String(str));
            return;
        }
        if(right > left){
            return;
        }
        if(left < n){
            dfs(n, left+1, right, str+"(");
        }
        if(right < n){
            dfs(n, left, right+1, str+")");
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

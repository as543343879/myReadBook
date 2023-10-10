package com.acm.lico.lookup;
/**
 括号生成:22
 2023-10-10 10:59:01
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
 // Related Topics 字符串 动态规划 回溯 👍 3397 👎 0

 **/

import java.util.ArrayList;
import java.util.List;

/**
 * Solution22 class
 *
 * @author 格林
 * @date 2023-10-10
 */
public class Solution22 {
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(NlogN) 错误 O(N）
     空间复杂度  O(logN) 错误 O(N)
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
     1. leftn 代表左括号的数量，rightn 代表右括号的数量， 都要小于等于n
     2. 保证 leftn >= rightn。 情况下 可以选择左括号或者右括号。 这里进行换回溯
     3. leftn == rightn  == n 时候 保存一个结果
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:40.6 MB,击败了91.54% 的Java用户
     5 执行结果
     */
    private List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        gengrate(0, 0, n, new StringBuilder());
        return result;
    }

    private void gengrate(int leftN, int rightN, int n , StringBuilder sb) {
        if(leftN == n && rightN == n) {
            result.add(sb.toString());
            return;
        }
        if(leftN < n) {
            sb.append('(');
            gengrate(leftN + 1, rightN, n, sb);
            sb.deleteCharAt(sb.length() - 1);

        }
        if(rightN < n && leftN > rightN ) {
            sb.append(')');
            gengrate(leftN, rightN + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}

package com.acm.lico.stack; /**
 739 ,每日温度
 //给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
 //在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 //
 //
 //
 // 示例 1:
 //
 //
 //输入: temperatures = [73,74,75,71,69,72,76,73]
 //输出: [1,1,4,2,1,1,0,0]
 //
 //
 // 示例 2:
 //
 //
 //输入: temperatures = [30,40,50,60]
 //输出: [1,1,1,0]
 //
 //
 // 示例 3:
 //
 //
 //输入: temperatures = [30,60,90]
 //输出: [1,1,0]
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= temperatures.length <= 10⁵
 // 30 <= temperatures[i] <= 100
 //
 //
 // Related Topics 栈 数组 单调栈 👍 1366 👎 0

 **/

import java.util.LinkedList;
import java.util.Deque;

/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询

 时间复杂度  O(N)
 空间复杂度  O(N)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。

 思路：
 单调栈， 单独递减的栈
 如果 栈空，或者栈顶元素 小于当前元素，入栈
 如果 当前元素 大于栈顶元素，  对栈元素出栈，并计算下标， 最后出栈。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:25 ms,击败了68.36% 的Java用户
 内存消耗:57 MB,击败了24.84% 的Java用户

 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return null;
        }
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new  LinkedList<>();
        for(int i = 0; i < n; i ++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer pop = stack.pop();
                res[pop] = i - pop ;
            }
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package com.acm.lico.stack; /**
 155 ,最小栈
 //设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 //
 // 实现 MinStack 类:
 //
 //
 // MinStack() 初始化堆栈对象。
 // void push(int val) 将元素val推入堆栈。
 // void pop() 删除堆栈顶部的元素。
 // int top() 获取堆栈顶部的元素。
 // int getMin() 获取堆栈中的最小元素。
 //
 //
 //
 //
 // 示例 1:
 //
 //
 //输入：
 //["MinStack","push","push","push","getMin","pop","top","getMin"]
 //[[],[-2],[0],[-3],[],[],[],[]]
 //
 //输出：
 //[null,null,null,null,-3,null,0,-2]
 //
 //解释：
 //MinStack minStack = new MinStack();
 //minStack.push(-2);
 //minStack.push(0);
 //minStack.push(-3);
 //minStack.getMin();   --> 返回 -3.
 //minStack.pop();
 //minStack.top();      --> 返回 0.
 //minStack.getMin();   --> 返回 -2.
 //
 //
 //
 //
 // 提示：
 //
 //
 // -2³¹ <= val <= 2³¹ - 1
 // pop、top 和 getMin 操作总是在 非空栈 上调用
 // push, pop, top, and getMin最多被调用 3 * 10⁴ 次
 //
 //
 // Related Topics 栈 设计 👍 1543 👎 0

 **/

import java.util.PriorityQueue;
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
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 用一个栈跟一个优先队列去做操作。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:5 ms,击败了32.74% 的Java用户
 内存消耗:43.5 MB,击败了15.89% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack155 {
    Stack<Integer> stack ;
    PriorityQueue<Integer> queue;
    public MinStack155() {
        stack = new Stack<>();
        queue = new PriorityQueue<>();
    }

    public void push(int val) {
        stack.push(val);
        queue.offer(val);
    }

    public void pop() {
        Integer pop = stack.pop();
        if(pop != null) {
            queue.remove(pop);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

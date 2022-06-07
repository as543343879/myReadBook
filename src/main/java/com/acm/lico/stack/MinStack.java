package com.acm.lico.stack;

/**
 * MinStack class
 *155. 最小栈
 * https://leetcode.cn/problems/min-stack/
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 *
 * 示例 1:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * @author 谢小平
 * @date 2022/6/7
 */

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Optional;
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
 栈
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 5 ms , 在所有 Java 提交中击败了 31.31% 的用户
 内存消耗： 43.2 MB , 在所有 Java 提交中击败了 41.25% 的用户
 通过测试用例： 31 / 31
 */
public class MinStack {
    LinkedList<Integer> list = new LinkedList();
    Integer minValue = null;

    public MinStack() {

    }

    public void push(int val) {
        if(minValue == null) {
            minValue = val;
        }
        else if (val < minValue) {
            minValue = val;
        }
        list.add(val);
    }

    public void pop() {

        int value = list.removeLast();
        if(minValue != null &&  minValue == value) {
            Optional<Integer> min = list.stream().min(Comparator.comparingInt(Integer::intValue));
            minValue = min.orElse(null);
        }
    }

    public int top() {
        return list.getLast();
    }

    public int getMin() {
        return minValue ;
    }
}

package com.acm.lico.doNotKnow;

import java.util.*;

/**
 * Solution341 class
 * https://leetcode.cn/problems/flatten-nested-list-iterator/
 *341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
 *
 * 实现扁平迭代器类 NestedIterator ：
 *
 * NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
 * int next() 返回嵌套列表的下一个整数。
 * boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。
 * 你的代码将会用下述伪代码检测：
 *
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 *     append iterator.next() to the end of res
 * return res
 * 如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nestedList = [[1,1],2,[1,1]]
 * 输出：[1,1,2,1,1]
 * 解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2：
 *
 * 输入：nestedList = [1,[4,[6]]]
 * 输出：[1,4,6]
 * 解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 * @author 格林
 * @date 2022-07-23
 */
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
 方法一：
 抽象成树，树的深度搜索。
方法二
 栈 模拟深度搜索。
 栈 存放的是一个list的迭代。 如果是 一个元素，就构造成list，然后放入。如果list 到了最后一个 弹出 这个元素。

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

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
 interface NestedInteger {

  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  public boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  public Integer getInteger();

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return empty list if this NestedInteger holds a single integer
  public List<NestedInteger> getList();
}

/**
 * 执行结果： 通过 显示详情 添加备注 执
 * 行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 43.6 MB , 在所有 Java 提交中击败了 57.38% 的用户
 * 通过测试用例： 43 / 43
 */
class NestedIterator implements Iterator<Integer> {
    List<Integer> vals ;
    Iterator<Integer> currIterator;
    public NestedIterator(List<NestedInteger> nestedList) {
        vals = new ArrayList<>(nestedList.size());
        dfs(nestedList);
        currIterator = vals.iterator();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for(NestedInteger ni : nestedList) {
            if(ni.isInteger()) {
                vals.add(ni.getInteger());
            } else {
                dfs(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return currIterator.next();
    }

    @Override
    public boolean hasNext() {
        return currIterator.hasNext();
    }
}


 class NestedIterator3 implements Iterator<Integer> {
    // 存储列表的当前遍历位置
    private Deque<Iterator<NestedInteger>> stack;

    public NestedIterator3(List<NestedInteger> nestedList) {
        stack = new LinkedList<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        // 由于保证调用 next 之前会调用 hasNext，直接返回栈顶列表的当前元素
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> it = stack.peek();
            if (!it.hasNext()) { // 遍历到当前列表末尾，出栈
                stack.pop();
                continue;
            }
            // 若取出的元素是整数，则通过创建一个额外的列表将其重新放入栈中
            NestedInteger nest = it.next();
            if (nest.isInteger()) {
                List<NestedInteger> list = new ArrayList<NestedInteger>();
                list.add(nest);
                stack.push(list.iterator());
                return true;
            }
            stack.push(nest.getList().iterator());
        }
        return false;
    }
}


/**
 * 思路错了
 */
class NestedIterator2 implements Iterator<Integer> {
    List<NestedInteger> nestedList;
    int currIndex ;
    int currListIndex;
    // 0 表示第一层
    int floor;
    Integer value;
    public NestedIterator2(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        currIndex = 0;
        currListIndex = 0;
        floor = 0;
    }

    @Override
    public Integer next() {
        return 0;
    }


    @Override
    public boolean hasNext() {
//        if (nestedList == null) {
//            return false;
//        }
//
//        NestedInteger preNode = nestedList.get(currIndex);
//        if(preNode.isInteger()) {
//            currIndex ++;
//            NestedInteger currNode = nestedList.get(currIndex);
//            if(currNode == null) {
//                return false;
//            } else if(!currNode.isInteger()) {
//                if(currNode.getList() == null || currNode.getList().size() == 0) {
//                    return false;
//                } else {
//                    currNode.get
//                }
//            } else {
//                return
//            }
//         // 是数组
//        } else {
//            return getListHashNext(preNode.getList());
//        }


        return true;

    }

    private boolean getListHashNext(List<NestedInteger> list) {
        return false;
    }
}

public class Solution341 {
}

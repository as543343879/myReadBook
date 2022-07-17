package com.acm.lico.doNotKnow;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Solution295 class
 * https://leetcode.cn/problems/find-median-from-data-stream/
 *295. 数据流的中位数

+
 +++++++++++++++++++++++++++++* 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
 * [[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]
 *
 * ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
 * [[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]
 *
 * 0 2 7 6 6 10
 * [null,null,6.0,null,8.0,null,6.0,null,6.0,null,6.0,null,5.5,null,6.0,null,5.5,null,5.0,null,4.0,null,3.0]
 * [null,null,6.0,null,8.0,null,6.0,null,3.0,null,6.0,null,5.5,null,6.0,null,5.5,null,5.0,null,4.0,null,3.0]
 * @author 格林
 * @date 2022-07-17
 */
public class Solution295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());



    }
}


/**
 * 执行结果： 通过 显示详情 添加备注
 * 执行用时： 99 ms , 在所有 Java 提交中击败了 74.45% 的用户
 * 内存消耗： 59.6 MB , 在所有 Java 提交中击败了 57.05% 的用户
 * 通过测试用例： 21 / 21 炫耀一下:
 */
class MedianFinder {
    PriorityQueue<Integer> queueLessNum ;
    PriorityQueue<Integer> queueNotLessNum ;
    public MedianFinder() {
        queueLessNum = new PriorityQueue<Integer>((o1,o2) -> o2 - o1 );
        queueNotLessNum = new PriorityQueue<Integer>((o1,o2) -> o1-o2);
    }

    public void addNum(int num) {
        if(queueLessNum.isEmpty() || num <= queueLessNum.peek()) {
           queueLessNum.offer(num);
           if(queueLessNum.size() -1  > queueNotLessNum.size()) {
               queueNotLessNum.offer(queueLessNum.poll());
           }
        } else {
            queueNotLessNum.offer(num);
            if(queueNotLessNum.size() > queueLessNum.size()) {
                queueLessNum.offer(queueNotLessNum.poll());
            }
        }

    }

    public double findMedian() {
        if (queueLessNum.size() == 0) {
            return 0;
        }
        if(queueLessNum.size() > queueNotLessNum.size()) {
            return queueLessNum.peek();
        } else {
            return (queueLessNum.peek() + queueNotLessNum.peek()) / 2.0;
        }
    }
}
/**
 * 时间超限
 */
class MedianFinder2 {
    TreeMap<Integer, Integer> map;
    int size ;
    public MedianFinder2() {
        map =new TreeMap<>();
        size = 0;
    }

    public void addNum(int num) {
        Integer res = map.get(num);
        if (res == null) {
            res = 1;
        } else {
            res +=1;
        }
        map.put(num,res);
        size ++;

    }

    public double findMedian() {
        // 偶数个
        if (size % 2 == 0) {
            int middle = size / 2;
            int iCount = 0;
            int index = 0;
            for (Map.Entry<Integer,Integer> i: map.entrySet()) {
                index += i.getValue();
                if(index >= middle) {
                    if(iCount == 0) {
                        iCount += i.getKey();
                    }
                    if(index > middle) {
                        iCount += i.getKey();
                        return iCount  / 2.0;
                    }

                }
            }

        } else {
           int middle = size / 2 + 1;
           int index = 0;
           for (Map.Entry<Integer,Integer> i: map.entrySet()) {
               index += i.getValue();
               if(index >= middle) {
                   return i.getKey();
               }
           }
        }

        return 0;

    }
}
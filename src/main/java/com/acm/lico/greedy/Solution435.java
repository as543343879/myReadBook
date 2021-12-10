package com.acm.lico.greedy;

/**
 * Solution435 class
 *435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * @author 谢小平
 * @date 2021/12/7
 */

import java.util.Arrays;
import java.util.Comparator;

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
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
     时间复杂度
     nO(nlogn)
     空间复杂度
    O(logn)
 2 定位问题
根据问题类型，确定采用何种算法思维。
    贪心
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过
 显示详情 添加备注 执行用时： 55 ms ,
 在所有 Java 提交中击败了 35.75% 的用户
 内存消耗： 94.6 MB ,
 在所有 Java 提交中击败了 27.01% 的用户 通过测试用例： 58 / 58
 */
public class Solution435 {

    public int eraseOverlapIntervals_error(int[][] intervals) {
        if(intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals,new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                int res = o1[0] - o2[0];
                if(res == 0) {
                    return o1[1] - o2[1];
                }
                return res;
            }
        });
        for(int[]  ints:intervals ) {
            System.out.println(Arrays.toString(ints) + " " + (ints[1] - ints[0]));
        }
        int left = 0, right = 1 ;
        int count = 0;
        while (right < intervals.length) {
             if(intervals[right][0] >= intervals[left][0] &&  intervals[right][0] < intervals[left][1] ) {
                int rightLen = intervals[right][1]  - intervals[right][0];
                int leftLen = intervals[left][1] - intervals[left][0];
                // 左边 距离大，剔除掉左边
                if(rightLen < leftLen ) {
                    System.out.println("left " + rightLen + ":" + leftLen + ": "+  intervals[left][0] + " : " + intervals[left][1]);
                    left = right;

                } else {
                    System.out.println("right "+rightLen + ":" + leftLen + ": "+    intervals[right][0]  +" : "+ intervals[right][1]);
                }
                count++;
            }else {
                 left = right;
             }

            right ++;
        }

        return count;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o1->o1[1]) );

//        for(int[]  ints:intervals ) {
//            System.out.println(Arrays.toString(ints) );
//        }
        int count = 1;
        int right = intervals[0][1];
        for(int i = 1; i < intervals.length; i ++) {
            if(intervals[i][0]>= right) {
                right =  intervals[i][1];
                count++;
            }
        }

        return intervals.length-count;
    }

    public static void main(String[] args) {

        int[][] arrays =   {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        System.out.println(new Solution435().eraseOverlapIntervals(arrays));

    }
}

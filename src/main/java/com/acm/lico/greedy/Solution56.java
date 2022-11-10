package com.acm.lico.greedy;

/**
 * Solution56 class
 * https://leetcode-cn.com/problems/merge-intervals/
 *56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * @author 谢小平
 * @date 2021/12/9
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(nlogn)
 空间复杂度
 O(nlon)
 2 定位问题
根据问题类型，确定采用何种算法思维。
    贪心算法。
 3 数据操作分析
    链表
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 7 ms , 在所有 Java 提交中击败了 48.68% 的用户
 内存消耗： 41 MB , 在所有 Java 提交中击败了 38.83% 的用户
 通过测试用例： 168 / 168
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(e->e[0]));
//        Arrays.stream(intervals).forEach(e->System.out.println(Arrays.toString(e)));
//        int begin = 0;
        int rightValue = intervals[0][1];
        int leftVale = intervals[0][0];
        for(int i = 1; i < intervals.length; i ++) {
            if(intervals[i][0] > rightValue) {
                int[] tempInt = new int[2];
                tempInt[0] = leftVale;
                tempInt[1] =  rightValue;
                res.add(tempInt);

                leftVale = intervals[i][0];
                rightValue = intervals[i][1];
            } else {
                rightValue = Math.max(rightValue,intervals[i][1]);

            }
        }

        int[] tempInt = new int[2];
        tempInt[0] = leftVale;
        tempInt[1] = rightValue;
        res.add(tempInt);

        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
//        int[][] test = {{2,3},{1,6},{6,7},{8,10},{15,18},{18,19}};
//        int[][] test = {{2,3},{4,5},{6,7},{1,10}};
        int[][] test = {{1,4},{2,3}};
        int[][] merge = new Solution56().merge(test);
        System.out.println("----------------------");
        Arrays.stream(merge).forEach(e->System.out.println(Arrays.toString(e)));
    }
}

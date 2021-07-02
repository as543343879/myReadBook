package com.acm.lico;

/**
 * Solution56 class
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
 * @author 格林
 * @date 2021-07-02
 */
public class Solution56 {
    /**
     *  时间复杂度很高
     *  官网， 根据 开始点进行 排序。 然后合并。
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int count = intervals.length;
        for(int i = 0; i < intervals.length; i ++) {
            for(int j = i + 1; j < intervals.length; j ++) {
                if( intervals[i][0] == -1 || intervals[j][0] == -1)
                    continue;
                if( (intervals[i][1] >= intervals[j][0] && intervals[i][1] <= intervals[j][1] ) ) {
                    intervals[j][0] =  Math.min( intervals[i][0],intervals[j][0]);
                    intervals[i][0] = intervals[i][1] = -1;
                    count --;
                } else if(intervals[j][1] >= intervals[i][0] && intervals[j][1] <= intervals[i][1]) {
                    intervals[j][1] = intervals[i][1];
                    intervals[j][0] = Math.min(intervals[i][0],intervals[j][0]);
                    intervals[i][0] = intervals[i][1] = -1;
                    count --;
                }

            }
        }
        int[][] res = new int[count][2] ;
        int j = 0;
        for(int i = 0; i < intervals.length; i ++) {
            if(intervals[i][0] != -1) {
                res[j][0] = intervals[i][0];
                res[j][1] = intervals[i][1];
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

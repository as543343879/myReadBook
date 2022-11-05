package com.acm.lico.array;

import java.lang.Math;
/**
 * 57. 插入区间
 * 中等
 * 657
 * 相关企业
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 *
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 */

/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 insert
 时间复杂度 O(N)
 空间复杂度 O(1)


 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询
 2 定位问题
 insert：
 找出第一个右边比 newInterval[0] 大于等于的。
 找出最后一个左边比  newInterval[1] 小于等于的
    要么处于最后
    要么处于最前
    要么处于中间
    要么被某几个覆盖
 insert2：
    错误 有交集 不应该 是根据 intervals 为标准， 而应该是 newInterval 为标准
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 insert:
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:43.6 MB,击败了68.65% 的Java用户
 */

public  class Solution57 {
    public static void main(String[] args) {
        System.out.println(new Solution57().insert(new int[][]{{3,5},{12,15}}, new int[]{6,6}));
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int n = intervals.length;
        int leftIndex = -1;
        int rightIndex = -1;
        for(int i = 0 ; i < n; i ++ ) {
            if(leftIndex == -1 && intervals[i][1] >= newInterval[0] ) {
                leftIndex = i;
            }
            if(intervals[i][0] <= newInterval[1] ) {
                rightIndex = i;
            }
            if(newInterval[1] < intervals[i][0]) {
                break;
            }
        }
        int[][] res ;
        //  处在最后
        if(leftIndex == -1 && rightIndex != -1) {
            res = new int[n + 1][2];
            System.arraycopy(intervals,0,res, 0,n);
            res[n] = newInterval;
            // 处在最前面
        } else if(leftIndex != -1 && rightIndex == -1) {
            res = new int[n + 1][2];
            System.arraycopy(intervals,0,res, 1,n);
            res[0] = newInterval;
            // 说明 处在中间
        } else if(leftIndex > rightIndex) {
            res = new int[n + 1][2];
            System.arraycopy(intervals,0,res, 0,leftIndex);
            res[leftIndex] = newInterval;
            System.arraycopy(intervals, leftIndex ,res,leftIndex + 1,n-leftIndex );
            // 进行合并
        } else {
            res = new int[n -(rightIndex - leftIndex)][2];
            for(int i = 0; i < leftIndex; i ++) {
                res[i] = intervals[i];
            }
            res[leftIndex][0] = Math.min(intervals[leftIndex][0],newInterval[0]);
            res[leftIndex][1] = Math.max(intervals[rightIndex][1],newInterval[1]);
            for(int i = rightIndex + 1; i < n; i ++ ) {
                res[++leftIndex] = intervals[i];
            }
        }
        return res;
    }
    /**
     * 错误 有交集 不应该 是根据 intervals 为标准， 而应该是 newInterval 为标准
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int start = -1, end = -1;
        int startIndex = -2;
        for(int i = 0; i < intervals.length; i ++) {
            if(newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
                start = i;
            }

            if(newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) {
                end = i;
            }
            if(newInterval[1] < intervals[i][0]) {
                startIndex = i-1;
                break;
            }
        }
        if(start == -1 && end == -1) {
            if(newInterval[0] < intervals[0][0] && newInterval[1] >intervals[intervals.length-1][1]){
                return new int[][]{newInterval};
            }
            if( startIndex == -1) {
                startIndex = 0;
            }
            int[][] res = new int[intervals.length + 1][2];
            int iAdd = 0;
            for(int i = 0 ;i < intervals.length ; i ++) {
                if(i == startIndex) {
                    res[i] = newInterval;
                    iAdd = 1;
                }
                res[i + iAdd] = intervals[i];
            }
            if(startIndex == -2){
                res[res.length - 1] = newInterval;
            }
            return res;
        } else {
            if(start != -1 && end != -1) {
                int[][] res = new int[intervals.length-(end - start)][2];
                for(int i = 0; i < start; i ++) {
                    res[i] = intervals[i];
                }
                res[start][0] = Math.min( newInterval[0], intervals[start][0]);
                res[start][1] = Math.max(newInterval[1], intervals[end][1]);

                for(int i = end + 1; i < intervals.length; i ++) {
                    res[++start] = intervals[i];
                }
                return res;
            }
            else if(start != -1) {
                intervals[start][0] = Math.min( newInterval[0], intervals[start][0]);
                intervals[start][1] = Math.max(newInterval[1], intervals[start][1]);
                return intervals;
            }
            else {
                intervals[end][0] = Math.min(newInterval[0], intervals[end][0]);
                intervals[end][1] = Math.max(newInterval[1], intervals[end][1]);
                return intervals;
            }


        }
    }
}
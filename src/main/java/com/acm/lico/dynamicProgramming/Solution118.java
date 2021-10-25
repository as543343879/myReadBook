package com.acm.lico.dynamicProgramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution118 class
 *118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * @author 谢小平
 * @date 2021/9/14
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
根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现

 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 内存消耗： 35.9 MB , 在所有 Java 提交中击败了 94.34% 的用户
 通过测试用例： 14 / 14 炫耀一下:
 */
public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> lineList = new ArrayList<>(1);
        lineList.add(1);
        int xWidth = 2;
        res.add(lineList);
        for(int i = 1; i <  numRows; i ++) {
             lineList = new ArrayList<>(i + 1);
            lineList.add(1);
            List<Integer> preList = res.get(i - 1);
            for(int x = 1; x < xWidth-1;  x++ ) {
                lineList.add( preList.get(x - 1) + preList.get(x));
            }
            lineList.add(1);
            xWidth++;
            res.add(lineList);

        }

        return res;
    }
}

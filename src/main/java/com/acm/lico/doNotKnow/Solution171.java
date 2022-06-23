package com.acm.lico.doNotKnow;

/**
 * 171. Excel 表列序号
 * https://leetcode.cn/problems/excel-sheet-column-number/
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 *
 * 例如：
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 * 示例 1:
 *
 * 输入: columnTitle = "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: columnTitle = "ZY"
 * 输出: 701
 */

import java.util.HashMap;
import java.util.Map;

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 o(N)
 空间复杂度
 O(1)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。
 进制转换 是 26 进制
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果

 */
class Solution171 {
    /**
     *执行结果： 通过 显示详情 添加备注
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 42.53% 的用户
     * 内存消耗： 41.5 MB , 在所有 Java 提交中击败了 5.02% 的用户
     * 通过测试用例： 1002 / 1002
     * @param columnTitle
     * @return
     */
    public int titleToNumber2(String columnTitle) {
        int res = 0;
        int n = columnTitle.length() - 1;
        for(int i = 0; i < columnTitle.length(); i ++) {
            int temp = (int) ((columnTitle.charAt(i) -  'A' + 1 )* Math.pow(26, n -i));
            res += temp;
        }
        return res;
    }

    static Map<Character,Integer> map;
    static {
         map = new HashMap<>();
        for(int i = 0; i < 26; i ++ ) {
            map.put((char) ('A' + i), i+1);
        }
    }

    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 42.53% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 58.56% 的用户
     * 通过测试用例： 1002 / 1002
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int n = columnTitle.length() - 1;
        for(int i = 0; i < columnTitle.length(); i ++) {
            int temp = (int) ( map.get(columnTitle.charAt(i)) * Math.pow(26, n -i));
            res += temp;
        }
        return res;
    }
}
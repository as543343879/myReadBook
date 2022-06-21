package com.acm.lico.doNotKnow;

import java.util.HashMap;

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(n) 一次遍历

 空间复杂度

    O(n) 一次遍历

 2 定位问题
根据问题类型，确定采用何种算法思维。
 分别处理 符号，整数位，小数点，小数位
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注 执行用时： 3 ms ,
 在所有 Java 提交中击败了 42.33% 的用户 内存消耗： 39.2 MB ,
 在所有 Java 提交中击败了 22.41% 的用户 通过测试用例： 39 / 39
 */
public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long newNumerator = numerator;
        long newDenominator = denominator;
        if (newNumerator % newDenominator == 0) {
            return String.valueOf(newNumerator / newDenominator);
        }
        StringBuilder res = new StringBuilder();

        if ( newNumerator * newDenominator < 0) {
            res.append('-');
        }

        newNumerator = Math.abs(newNumerator);
        newDenominator = Math.abs(newDenominator);

        res.append(String.valueOf(newNumerator / newDenominator) + '.');
        newNumerator %= newDenominator;
        HashMap<Long, Integer> map = new HashMap<>();
        while (newNumerator != 0) {
            map.put(newNumerator, res.length());
            newNumerator *= 10;
            res.append(newNumerator /  newDenominator);
            newNumerator %= newDenominator;
            if (map.containsKey(newNumerator)) {
                int index = map.get(newNumerator);
                return String.format("%s(%s)",res.substring(0,index), res.substring(index));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
         System.out.println(new Solution166().fractionToDecimal(-2147483648
                ,-1));
    }
}
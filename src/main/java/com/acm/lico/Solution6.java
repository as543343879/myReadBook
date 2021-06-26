package com.acm.lico;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution6 class
 *
 * PAYPALISHIRING
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  思路一  按照行 便利， 数据归纳法归纳出规律，找规律 太耗时间
 *  思路二 编译一遍。
 * @author 格林
 * @date 2021-06-26
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int len = s.length();
        List<StringBuilder> stringBuilders = new ArrayList<>();
        for(int i = 0; i < numRows; i ++) {
            stringBuilders.add(new StringBuilder());
        }
        boolean isDown = false;
        int curRow = 0;
        for(int i = 0; i < len; i ++) {
            stringBuilders.get(curRow).append(s.charAt(i));
            if(curRow == 0 || curRow == numRows - 1)
                isDown = !isDown;

            curRow += isDown ? 1 : -1;
        }

        StringBuilder t = new StringBuilder();
        for(StringBuilder stringBuilder : stringBuilders) {
            t.append(stringBuilder);
        }
        return t.toString();
    }
}

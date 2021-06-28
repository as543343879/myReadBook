package com.acm.lico;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution13 class
 *13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-27
 */
public class Solution13 {
    static Map<Character,Integer> map = new HashMap<>();
    static {
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }
    public int romanToInt(String s) {
        int len = s.length();
        int sum = 0;
        for(int i = 0; i < len; i ++) {
            int next = i + 1;
            if(next < len &&(( s.charAt(i) == 'I' && (s.charAt(next) == 'V' || s.charAt(next) == 'X')) || s.charAt(i) == 'X'&& (s.charAt(next) == 'L' || s.charAt(next) == 'C') || s.charAt(i) == 'C' && (s.charAt(next) == 'D' || s.charAt(next) == 'M') )) {
                sum+= map.get(s.charAt(next)) -  map.get(s.charAt(i)) ;
                i++;
            } else {
                sum+=  map.get(s.charAt(i));
            }

        }
        return  sum;
    }
    public static void main(String[] args) {
       System.out.println( new Solution13().romanToInt("IV"));
    }
}

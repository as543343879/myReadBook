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


    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N)
     空间复杂度  O(1)
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
     思路：start 下标为0
     1. 每次选取两个数，如果左边的数小于右边的数，就算减法 右移两位 。否则就只算一个字符，右移一位。
     2. 重复 第一步。 把值求和
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果1
     解答成功:
     执行耗时:3 ms,击败了70.00% 的Java用户
     内存消耗:42.4 MB,击败了71.91% 的Java用户
     */
    public int romanToIntNew2(String s) {
        int i = 0;
        int index = s.length() - 1;
        int res = 0;
        while (i < s.length()) {
            int temp1 = map.get(s.charAt(i)), temp2;
            if(i == index || (temp1  >= (temp2 =  map.get(s.charAt(i + 1)))) ) {
                res += temp1;
                i++;
            } else {
                res += temp2 - temp1;
                i+=2;
            }
        }
        return res;
    }
    public static void main(String[] args) {
       System.out.println( new Solution13().romanToIntNew2("LVIII"));
    }
}

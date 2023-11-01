package com.acm.lico.string;

/**
 整数转罗马数字:12
 2023-11-01 14:10:27
 //罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 //
 //
 //字符          数值
 //I             1
 //V             5
 //X             10
 //L             50
 //C             100
 //D             500
 //M             1000
 //
 // 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V +
 //II 。
 //
 // 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
 // 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 //
 //
 // I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 // X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 // C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 //
 //
 // 给你一个整数，将其转为罗马数字。
 //
 //
 //
 // 示例 1:
 //
 //
 //输入: num = 3
 //输出: "III"
 //
 // 示例 2:
 //
 //
 //输入: num = 4
 //输出: "IV"
 //
 // 示例 3:
 //
 //
 //输入: num = 9
 //输出: "IX"
 //
 // 示例 4:
 //
 //
 //输入: num = 58
 //输出: "LVIII"
 //解释: L = 50, V = 5, III = 3.
 //
 //
 // 示例 5:
 //
 //
 //输入: num = 1994
 //输出: "MCMXCIV"
 //解释: M = 1000, CM = 900, XC = 90, IV = 4.
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= num <= 3999
 //
 //
 // Related Topics 哈希表 数学 字符串 👍 1208 👎 0

 **/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution12 {
    int[] valus = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] names = new String[]{"M", "CM", "D", "CD","C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     1 复杂度分析
    估算问题中复杂度的上限和下限
     时间复杂度 O(1)
     空间复杂度 O(1)
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
        思路：
            1. 枚举 所有可能的罗马数字，
            2. 然后从大到小减少。 就是最终的结果。
     3 数据操作分析
        根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     */
    public String intToRoman(int num) {
        if(num == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < valus.length; i ++) {
            while (num >= valus[i]) {
                num -= valus[i];
                sb.append(names[i]);
            }

        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

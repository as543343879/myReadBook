package com.acm.lico; /**
 8 ,字符串转换整数 (atoi)
 //请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 //
 // 函数 myAtoi(string s) 的算法如下：
 //
 //
 // 读入字符串并丢弃无用的前导空格
 // 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 // 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 // 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤
 //2 开始）。
 // 如果整数数超过 32 位有符号整数范围 [−2³¹, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2³¹ 的整数应该被固
 //定为 −2³¹ ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 // 返回整数作为最终结果。
 //
 //
 // 注意：
 //
 //
 // 本题中的空白字符只包括空格字符 ' ' 。
 // 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 //
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：s = "42"
 //输出：42
 //解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 //第 1 步："42"（当前没有读入字符，因为没有前导空格）
 //         ^
 //第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 //         ^
 //第 3 步："42"（读入 "42"）
 //           ^
 //解析得到整数 42 。
 //由于 "42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 42 。
 //
 // 示例 2：
 //
 //
 //输入：s = "   -42"
 //输出：-42
 //解释：
 //第 1 步："   -42"（读入前导空格，但忽视掉）
 //            ^
 //第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
 //             ^
 //第 3 步："   -42"（读入 "42"）
 //               ^
 //解析得到整数 -42 。
 //由于 "-42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 -42 。
 //
 //
 // 示例 3：
 //
 //
 //输入：s = "4193 with words"
 //输出：4193
 //解释：
 //第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
 //         ^
 //第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 //         ^
 //第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
 //             ^
 //解析得到整数 4193 。
 //由于 "4193" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 4193 。
 //
 //
 //
 //
 // 提示：
 //
 //
 // 0 <= s.length <= 200
 // s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 //
 //
 // Related Topics 字符串 👍 1624 👎 0

 **/

/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询

 自己思路
 时间复杂度 O(N)
 空间复杂度 O(1)

 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路： 符号位置后面 就是 只能是数字
 1 根据 是否出现符号位置，判断正负，
 2 如果是数字字符， * 10  + 1， 假如大于max return max ，小于 min， return min.

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路
 解答成功:
 执行耗时:1 ms,击败了100.00% 的Java用户
 内存消耗:41.3 MB,击败了67.35% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution8 {
    public int myAtoi(String s) {
        char[] charS = s.toCharArray();
        int symbo = 0;
        long res = 0;
        boolean isToDigit = false;
        for(char c: charS ) {
            if(!isToDigit && (c == '-' || c == '+')) {
                symbo = c == '-' ? -1:1;
                isToDigit = true;
            } else if(Character.isDigit(c)) {
                isToDigit = true;
                res = res * 10 + c - '0';
                long temp = symbo == 0 ? res  :  res * symbo;

                if( temp> Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if( temp < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if(isToDigit) {
                    break;
                }
                if( !( c == ' ')) {
                    break;
                }
            }


        }
        return symbo == 0 ? (int)res  :  (int)res * symbo;
    }

    public int myAtoi2(String s) {
        if(s == null|| s.length() == 0) {
            return 0;
        }
        long res = 0;
        boolean isRes = true;
        // 0 未初始化 1 正数 2 负数
        byte isNegative = 0;
        int i = 0;
        do {
            char c = s.charAt(i);
            if( (c == '-' || c == '+' ) && isRes) {
                if(isNegative == 0) {
                    if(c == '-') {
                        isNegative = 2;
                    } else {
                        isNegative = 1;
                    }
                } else {
                    return (int) res;
                }
            }
            else if( c >= '0' && c <= '9') {
                if(isRes) {
                    isRes = false;
                    res = isNegative == 2 ? - (c - '0') :  c - '0';
                }
                for(int j = i + 1; j < s.length()  ; j ++) {
                    c = s.charAt(j);
                    if(c >= '0' && c <= '9') {

                        res = res * 10 + ( isNegative == 2 ? - (c- '0') : c - '0');
                        if(res > Integer.MAX_VALUE  ) {
                            return Integer.MAX_VALUE;
                        } else if(res < Integer.MIN_VALUE ) {
                            return Integer.MIN_VALUE;
                        }
                    } else {
                        return (int) res;
                    }
                }
                return (int) res;
                // if(c != ' ')
            } else  {
                if(! (c == ' ' && isNegative == 0 ))
                    return (int) res;
            }
            i ++;
        } while (i < s.length());
        return (int) res;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println( new Solution8().myAtoi2("   +0 123"));
    }

}
//leetcode submit region end(Prohibit modification and deletion)

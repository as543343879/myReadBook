package com.acm.lico;

/**
 * Solution38 class
 *38. 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * @author 格林
 * @date 2021-06-29
 */
public class Solution38 {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        return miaoShu(countAndSay(n-1));
    }

    public String miaoShu(String key) {
        StringBuilder res = new StringBuilder();
        int i;
        for( i = 0; i < key.length() -1; i ++) {
            int count = 1;
            char t = key.charAt(i);
            while ((i < key.length() -1) && t == key.charAt(i + 1)  ) {
                count ++;
                i ++;
            }
            res.append(count).append(t);
        }
        if(i != key.length()) {
            res.append(1).append(key.charAt(key.length() - 1));
        }
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Solution38().countAndSay(4));
    }

}

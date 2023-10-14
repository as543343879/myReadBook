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


    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N)
     空间复杂度  O(1) 错误 应该 是O(M) M 最大连续长度
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
     思路： 描述 外观数列
     1. 先对1 描述
     2. 然后 循环n次。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:7 ms,击败了47.83% 的Java用户
     内存消耗:38.8 MB,击败了91.65% 的Java用户

     */
    public String countAndSayNew20(int n) {
        String res = "1";
        while (n > 1) {
            StringBuilder tempRes = new StringBuilder();
            for(int i = 0; i < res.length(); i ++) {
                int j = i + 1;
                while ( (j< res.length()) && res.charAt(j) == res.charAt(i) ) {
                    j ++;
                }
                tempRes.append(j - i).append(res.charAt(i));
                i = j -1;
            }
            res = tempRes.toString();
            n --;
        }
        return res;
    }

}

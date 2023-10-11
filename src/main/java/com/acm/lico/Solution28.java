package com.acm.lico;

/**
 * Solution28 class
 *28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 *
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * @author 格林
 * @date 2021-06-27
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0  )
            return 0;
        int needleLen = needle.length();
        for(int i = 0; i + needleLen <= haystack.length(); i ++ ) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int j = i + 1;
                int k = 1;
                while (j < haystack.length() && k < needleLen && (haystack.charAt(j) == needle.charAt(k))) {
                    j ++;
                    k ++;
                }
                if(k == needleLen ){
                    return i;
                }
            }

        }

        return -1;
    }


    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N*M)
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
     思路：
     1. 循环遍历 haystack， 找到匹配 needle 的。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:1 ms,击败了40.96% 的Java用户
     内存消耗:39.2 MB,击败了82.04% 的Java用户
     */
    public int strStrNew2(String haystack, String needle) {
        int needleLen = needle.length();
        for(int i = 0; i <= haystack.length() - needleLen; i ++  ) {

            boolean tempRes = true;
            for(int j = 0; j <needleLen; j ++) {
                if(needle.charAt(j) != haystack.charAt(i + j) ) {
                    tempRes = false;
                    break;
                }
            }
            if(tempRes) {
                return i;
            }
        }
        return -1;
    }
}

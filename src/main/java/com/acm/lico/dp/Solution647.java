package com.acm.lico.dp;

/**
 回文子串:647
 2023-02-14 22:24:26
 //给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 //
 // 回文字符串 是正着读和倒过来读一样的字符串。
 //
 // 子字符串 是字符串中的由连续字符组成的一个序列。
 //
 // 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：s = "abc"
 //输出：3
 //解释：三个回文子串: "a", "b", "c"
 //
 //
 // 示例 2：
 //
 //
 //输入：s = "aaa"
 //输出：6
 //解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= s.length <= 1000
 // s 由小写英文字母组成
 //
 //
 // Related Topics 字符串 动态规划 👍 1073 👎 0

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

 时间复杂度  O(N^2)
 空间复杂度 O(1)
 2 定位问题
根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
中心扩展方法
 枚举中心点， n长度的 字符串， 中心点 有 n * 2 -1 个。 每个的 left = i/2 ,right = i/2 + i % 2.
 然后不断count


 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:3 ms,击败了84.72% 的Java用户
 内存消耗:39.2 MB,击败了98.37% 的Java用户
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution647 {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for(int i = 0; i < n * 2 - 1; i ++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            while (left >=0 && right < n && s.charAt(left) == s.charAt(right)) {
                left --;
                right ++;
                res ++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package com.acm.lico; /**
 14 ,最长公共前缀
 //编写一个函数来查找字符串数组中的最长公共前缀。
 //
 // 如果不存在公共前缀，返回空字符串 ""。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：strs = ["flower","flow","flight"]
 //输出："fl"
 //
 //
 // 示例 2：
 //
 //
 //输入：strs = ["dog","racecar","car"]
 //输出：""
 //解释：输入不存在公共前缀。
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= strs.length <= 200
 // 0 <= strs[i].length <= 200
 // strs[i] 仅由小写英文字母组成
 //
 //
 // Related Topics 字典树 字符串 👍 2679 👎 0

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

 时间复杂度
 O(N*N)
 空间复杂度
 O(1)

 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 字典树，
 暴力遍历： 取第一行当作列号， 底二行开始的行号 逐渐比较。


 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路： 暴力遍历
 解答成功:
 执行耗时:1 ms,击败了69.23% 的Java用户
 内存消耗:39.4 MB,击败了55.31% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution14 {
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
     先从第一个字符串遍历。res 存储结果
     如果 str[0][i]，等后面字符串都相等， res + str[0][i].
     返回res
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:1 ms,击败了70.62% 的Java用户
     内存消耗:39.2 MB,击败了57.97% 的Java用户
     */
    public String longestCommonPrefixNew2(String[] strs) {
        StringBuilder sbRes = new StringBuilder();
        if(strs.length > 0) {
            String strLine1 = strs[0];
            for(int i = 0; i < strLine1.length(); i ++) {
                char t = strLine1.charAt(i);
                boolean oneRes = true;
                for(int l = 1; l < strs.length; l ++) {
                    if((strs[l].length() <= i) || ( t != strs[l].charAt(i))) {
                        oneRes = false;
                        break;
                    }
                }
                if(oneRes) {
                    sbRes.append(t);
                } else {
                    break;
                }
            }
        }
        return sbRes.toString();
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int pre = 0;
        for(int i = 0; i < strs[0].length(); i ++) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j ++ ) {
                if(i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return  res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();
    }

    /**
     * 旧的 以前刷过的题目
     * @param strs
     * @return
     */
    public String longestCommonPrefix_old(String[] strs) {
        StringBuilder commonPre = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i ++) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j ++) {
                if(strs[j].length() < i + 1) {
                    return commonPre.toString();
                }
                if(strs[j].charAt(i) != c) {
                    return commonPre.toString();
                }
            }
            commonPre.append(c);
        }
        return commonPre.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

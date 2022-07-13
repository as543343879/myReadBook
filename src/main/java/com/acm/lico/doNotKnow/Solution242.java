package com.acm.lico.doNotKnow;

/**
 * Solution242 class
 *242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * @author 谢小平
 * @date 2022/7/13
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(N+M)
 空间复杂度
 O(N+M)

    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
 桶排序思路，26位的int 数组当存储
根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
 内存消耗： 41.7 MB , 在所有 Java 提交中击败了 37.61% 的用户
 通过测试用例： 36 / 36
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] sMap = new int[26];
        int[] tMap = new int[26];
        for(char i: s.toCharArray()) {
            sMap[i - 'a'] ++;
        }
        for(char i: t.toCharArray()) {
            tMap[i - 'a'] ++;
        }
        for(int i = 0; i < 26; i ++) {
            if(sMap[i] != tMap[i]) {
                return false;
            }
        }
        return true;
    }
}

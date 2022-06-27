package com.acm.lico.doNotKnow;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Solution179 class
 * https://leetcode.cn/problems/largest-number/
 *179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * [3,30,34,5,9]
 * 输出：
 * "9534303"
 * 预期结果：
 * "9534330"
 *
 *
 * [432,43243]
 * 输出：
 * "43243243"
 * 预期结果：
 * "43243432"
 * @author 谢小平
 * @date 2022/6/27
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(n)
 空间复杂度
 O(n)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
组成最大的数：
  分为两种情况：
    第一种 互相不为子串：
        根据字典序大的排前面
    第二种
        互相为子串
            o1 为子串
            compare(o1,o2.subString(o1.len));
            o2 为字串
            compate(o1.subString(o2.len),o2);

 根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注 执行用时： 2 ms ,
 在所有 Java 提交中击败了 98.90% 的用户 内存消耗： 39.6 MB ,
 在所有 Java 提交中击败了 94.07% 的用户 通过测试用例： 230 / 230
 */
public class Solution179 {

    /**
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for(int i = 0; i < nums.length; i ++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() < o2.length()) {
                    if(o2.startsWith(o1)) {
                        o2 = o2.substring(o1.length()) ;
                        return this.compare(o1, o2);

                    }
                } else if (o1.length() > o2.length()){
                    if(o1.startsWith(o2)) {
                        o1 = o1.substring(o2.length());
                        return this.compare(o1,o2);
                    }
                }
                return o2.compareTo(o1);
            }
        });

        StringBuilder res = new StringBuilder();
        for(String t: numStrs) {
            res.append(t);
        }
        return res.charAt(0) == '0' ? "0": res.toString();
    }

    public static void main(String[] args) {
//        System.out.println("30".compareTo("3"));
        int[] test ={432,43243};
//        test = new  int[]{999999991,9};

        System.out.println(new Solution179().largestNumber(test));
    }
}

package com.acm.lico;

/**
 * Solution66 class
 * 66. 加一
 *给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-07-02
 */
public class Solution66 {
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N)
     空间复杂度  O(N)
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
     1. 某位加一，不断循环；
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:39.7 MB,击败了85.90% 的Java用户
     */
    public int[] plusOneNew20(int[] digits) {
        int pre = 1;
        for(int i = digits.length - 1; i >= 0; i --) {
            int temp = pre + digits[i];
            digits[i] = temp % 10;
            pre = temp / 10;
            if(pre == 0) {
                break;
            }
        }
        if(pre == 1) {
            int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length );
            res[0] = 1;
            return res;
        }
        return digits;
    }
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length , sum;
        for(int i = n -1; i >= 0; i -- ) {
            sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
            if(carry == 0){
                return digits;
            }
        }
        if(carry == 1) {
            int[] t = new int[n + 1];
            System.arraycopy(digits,0,t,1,n);
            t[0] = 1;
            return t;
        }
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


}

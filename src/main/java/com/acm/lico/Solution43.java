package com.acm.lico; /**
 * 43 ,字符串相乘
 * //给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * //
 * // 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //输入: num1 = "2", num2 = "3"
 * //输出: "6"
 * //
 * // 示例 2:
 * //
 * //
 * //输入: num1 = "123", num2 = "456"
 * //输出: "56088"
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= num1.length, num2.length <= 200
 * // num1 和 num2 只能由数字组成。
 * // num1 和 num2 都不包含任何前导零，除了数字0本身。
 * //
 * //
 * // Related Topics 数学 字符串 模拟 👍 1169 👎 0
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

 自己思路+ 参考：
 时间复杂度 O(N*M)
 空间复杂度  O(N+M)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 自己思路：
 pre = (num1[i-1] * num2[j-1]) % 10
 rest[i] = rest[i] +  pre + num1[i] * num2[j]
 错误：
  优化竖式，假如 乘集 是12 第一位1在 i + j, 第二 i + j + 1;
   - 高位在底下标， 低位在高下标。 低位 又是下一个乘积的高位。
   - 乘数 num1 位数为 M，被乘数 num2 位数为 N， num1 x num2 结果 res 最大总位数为 M+N
   - num1[i] x num2[j] 的结果为 tmp(位数为两位，"0x", "xy" 的形式)，其第一位位于 res[i+j]，第二位位于 res[i+j+1]。

 官网思路2：multiply4
    先一个个 位乘，然后大数相加。
        乘的时候 ，保证 j > i 的位置的前导0. 来保证 不是 个位数开始成绩的。


 4 编码实现
 5 执行结果
 自己思路+ 参考：
 解答成功:
 执行耗时:3 ms,击败了68.47% 的Java用户
 内存消耗:41.4 MB,击败了62.03% 的Java用户

 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution43 {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) {
            return null;
        }
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        int resLen = num1.length() + num2.length();
        int[] res = new int[resLen];
        for(int i = num1.length() - 1; i >= 0; i --) {
            int n1 = num1.charAt(i) - '0';
            for(int j = num2.length() -1 ; j >= 0; j --) {
                int n2 = num2.charAt(j) - '0';
                int sum =  res[i + j + 1 ] +  n1 * n2;
                res[i + j + 1] = sum % 10;
                res[i + j]  += sum / 10;
            }
        }
        StringBuilder resBuilder = new StringBuilder();

        for(int i =0; i < resLen; i ++ ) {
            if(res[i] == 0 && i == 0) {
                continue;
            }
            resBuilder.append(res[i]);
        }
        return resBuilder.toString();
    }

    /**
     * 以前刷的记录
     * @param num1
     * @param num2
     * @return
     */
    public String multiplyOld(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];
        int n1, n2,sum;
        for(int i = n - 1; i >= 0 ; i --) {
            n1 = num1.charAt(i) - '0';
            for(int j = m - 1; j >= 0; j --) {
                n2 = num2.charAt(j) - '0';
                sum = (result[i + j  + 1] + n1 * n2);
                result[i + j + 1] = sum % 10;
                result[i + j ] += sum / 10;
            }
        }
        StringBuilder resultStr = new StringBuilder();
        for(int i = 0; i < result.length; i ++) {
            if(i == 0 &&  result[i] == 0)
                continue;
            resultStr.append(result[i]);
        }
        return resultStr.toString();
    }

    public String multiply4(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

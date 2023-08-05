package com.acm.lico.doNotKnow; /**
 344 ,反转字符串
 //编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 //
 // 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：s = ["h","e","l","l","o"]
 //输出：["o","l","l","e","h"]
 //
 //
 // 示例 2：
 //
 //
 //输入：s = ["H","a","n","n","a","h"]
 //输出：["h","a","n","n","a","H"]
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= s.length <= 10⁵
 // s[i] 都是 ASCII 码表中的可打印字符
 //
 //
 // Related Topics 双指针 字符串 👍 770 👎 0

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
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 左右交换就可以了
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:49.5 MB,击败了5.00% 的Java用户

 旧的 执行结果： 通过 显示详情 添加备注
 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 内存消耗： 47.9 MB , 在所有 Java 提交中击败了 84.53% 的用户
 通过测试用例： 477 / 477 炫耀一下:
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution344 {
    public void reverseString(char[] s) {
        if(s == null || s.length == 0) {
            return ;
        }
        int left = 0;
        int right = s.length - 1;
        char t;
        while (left < right) {
            t = s[left];
            s[left] = s[right];
            s[right] = t;
            left ++;
            right --;
        }
    }

    public void reverseStringOld(char[] s) {
        int middle = (s.length - 1) / 2;
        int n = s.length-1;
        for(int i = 0; i <= middle; i ++) {
            char t = s[i];
            s[i] = s[n - i];
            s[n-i] = t;
        }
    }

    public static void main(String[] args) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 9 ,回文数
 //给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 //
 // 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 //
 //
 // 例如，121 是回文，而 123 不是。
 //
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：x = 121
 //输出：true
 //
 //
 // 示例 2：
 //
 //
 //输入：x = -121
 //输出：false
 //解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 //
 //
 // 示例 3：
 //
 //
 //输入：x = 10
 //输出：false
 //解释：从右向左读, 为 01 。因此它不是一个回文数。
 //
 //
 //
 //
 // 提示：
 //
 //
 // -2³¹ <= x <= 2³¹ - 1
 //
 //
 //
 //
 // 进阶：你能不将整数转为字符串来解决这个问题吗？
 //
 // Related Topics 数学 👍 2337 👎 0

 **/
/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度 O(N)
 空间复杂度 O(1)
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
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 时间6 ms击败44.37% 内存40.3 MB击败98.81%
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution9 {
    public boolean isPalindrome(int x) {
        String xStr = x + "";
        int left = 0, right = xStr.length() - 1;
        while (left < right) {
            if(xStr.charAt(left) != xStr.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package com.acm.lico.math; /**
 292 ,Nim 游戏
 //你和你的朋友，两个人一起玩 Nim 游戏：
 //
 //
 // 桌子上有一堆石头。
 // 你们轮流进行自己的回合， 你作为先手 。
 // 每一回合，轮到的人拿掉 1 - 3 块石头。
 // 拿掉最后一块石头的人就是获胜者。
 //
 //
 // 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
 //
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：n = 4
 //输出：false
 //解释：以下是可能的结果:
 //1. 移除1颗石头。你的朋友移走了3块石头，包括最后一块。你的朋友赢了。
 //2. 移除2个石子。你的朋友移走2块石头，包括最后一块。你的朋友赢了。
 //3.你移走3颗石子。你的朋友移走了最后一块石头。你的朋友赢了。
 //在所有结果中，你的朋友是赢家。
 //
 //
 // 示例 2：
 //
 //
 //输入：n = 1
 //输出：true
 //
 //
 // 示例 3：
 //
 //
 //输入：n = 2
 //输出：true
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= n <= 2³¹ - 1
 //
 //
 // Related Topics 脑筋急转弯 数学 博弈 👍 677 👎 0

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
 判断是否 是4的倍数。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:38.3 MB,击败了33.79% 的Java用户

 以前的官方思路：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:38.4 MB,击败了43.19% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution292 {
    public boolean canWinNim(int n) {
        return   n % 4 != 0;
    }

    public boolean canWinNimOld(int n) {
        return n % 4 != 0;
    }
    public boolean canWinNim2(int n) {
        if(n <= 3) {
            return true;
        }
        int res = 1;
        for(int i = 2; i <= n; i ++) {
            res^= i;
        }
        return res == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

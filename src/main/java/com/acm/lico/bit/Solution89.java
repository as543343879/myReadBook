package com.acm.lico.bit; /**
 89 ,格雷编码
 //n 位格雷码序列 是一个由 2ⁿ 个整数组成的序列，其中：
 //
 //
 // 每个整数都在范围 [0, 2ⁿ - 1] 内（含 0 和 2ⁿ - 1）
 // 第一个整数是 0
 // 一个整数在序列中出现 不超过一次
 // 每对 相邻 整数的二进制表示 恰好一位不同 ，且
 // 第一个 和 最后一个 整数的二进制表示 恰好一位不同
 //
 //
 // 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：n = 2
 //输出：[0,1,3,2]
 //解释：
 //[0,1,3,2] 的二进制表示是 [00,01,11,10] 。
 //- 00 和 01 有一位不同
 //- 01 和 11 有一位不同
 //- 11 和 10 有一位不同
 //- 10 和 00 有一位不同
 //[0,2,3,1] 也是一个有效的格雷码序列，其二进制表示是 [00,10,11,01] 。
 //- 00 和 10 有一位不同
 //- 10 和 11 有一位不同
 //- 11 和 01 有一位不同
 //- 01 和 00 有一位不同
 //
 //
 // 示例 2：
 //
 //
 //输入：n = 1
 //输出：[0,1]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= n <= 16
 //
 //
 // Related Topics 位运算 数学 回溯 👍 578 👎 0

 **/

import java.util.ArrayList;
import java.util.List;
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
 官方思路：
 格雷码的规则是： g(i) = b(i+1) ^ b(i), 0<=i <=n.  g 表示格雷码， b 表示 n位二进制数， g(i), b(i) 分别表示 g, b的第i位。且 b(n) = 0


 https://blog.csdn.net/jingfengvae/article/details/51691124
 https://upload-images.jianshu.io/upload_images/9547570-21232ba508430a5f.jpeg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:4 ms,击败了97.94% 的Java用户
 内存消耗:47.8 MB,击败了19.44% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution89 {
    public List<Integer> grayCode(int n) {
        int size = 1 << n;
        List<Integer> res = new ArrayList<>(size);
        for(int i = 0; i < size; i ++) {
            res.add((i >> 1) ^ i) ;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

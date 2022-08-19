package com.acm.lico.doNotKnow;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution412 class
 * https://leetcode.cn/problems/fizz-buzz/
 *412. Fizz Buzz
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 *
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i （以字符串形式）如果上述条件全不满足。
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["1","2","Fizz"]
 * 示例 2：szdfcgbhnjmk,.l;/"
 * `    ]
 *
 * 输入：n = 5
 * 输出：["1","2","Fizz","4","Buzz"]
 * 示例 3：
 *
 * 输入：n = 15
 * 输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 * @author 谢小平
 * @date 2022/8/18
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限

 时间复杂度
 O(N)
 空间复杂度
 O(1) 返回值 不计算到空间复杂度里面
 // 错误
 O(N)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。
 模拟题：

    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 1 ms , 在所有 Java 提交中击败了 99.92% 的用户
 内存消耗： 42.2 MB , 在所有 Java 提交中击败了 89.30% 的用户
 通过测试用例： 8 / 8
 */
public class Solution412 {

    public List<String> fizzBuzz(int n) {
        String fizzBuzz35 = "FizzBuzz";
        String fizz3 = "Fizz";
        String buzz5 = "Buzz";
        List<String> listRes = new ArrayList<>();
        for(int i =1; i <= n; i ++){
            int i3 = i % 3;
            int i5 = i % 5;
            if(i3 ==0 && i5 == 0) {
                listRes.add(fizzBuzz35);
            } else if(i3 == 0) {
                listRes.add(fizz3);
            } else if(i5 == 0) {
                listRes.add(buzz5);
            } else {
                listRes.add(String.valueOf(i));
            }
        }
        return listRes;
    }
}

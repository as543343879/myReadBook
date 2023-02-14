package com.acm.lico.doNotKnow; /**
 621 ,任务调度器
 //给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个
 //单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 //
 // 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 //
 // 你需要计算完成所有任务所需要的 最短时间 。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：tasks = ["A","A","A","B","B","B"], n = 2
 //输出：8
 //解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 //     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 //
 // 示例 2：
 //
 //
 //输入：tasks = ["A","A","A","B","B","B"], n = 0
 //输出：6
 //解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
 //["A","A","A","B","B","B"]
 //["A","B","A","B","A","B"]
 //["B","B","B","A","A","A"]
 //...
 //诸如此类
 //
 //
 // 示例 3：
 //
 //
 //输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 //输出：16
 //解释：一种可能的解决方案是：
 //     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待
 //命) -> (待命) -> A
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= task.length <= 10⁴
 // tasks[i] 是大写英文字母
 // n 的取值范围为 [0, 100]
 //
 //
 // Related Topics 贪心 数组 哈希表 计数 排序 堆（优先队列） 👍 1066 👎 0

 **/

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.Set;

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
 自己思路： 思路错误
 先根据任务名分组： {A,2}, {B,3}, {C,4}; 宽度窗口为 n
 大顶堆 存 数据。
 time = iValue + n * iValue ;
 继续取出 value 。 直到 n* iValue 被消耗。 没消耗完就 重新放入队列。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 权重
 4 编码实现
 5 执行结果
 */
//leetcode submit region begin(Prohibit modification and deletion)



class Solution62 {

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2.getValue() - o1.getValue() ));
        Map<Character, Integer> map = new HashMap<>();
        for(char t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        entries.forEach(e->{
            priorityQueue.add(e);
        });
        int res = 0 ;
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> maxValue = priorityQueue.poll();
            res += maxValue.getValue() + n * maxValue.getValue();
            int tempSize = n * maxValue.getValue();
            int countValueEqual = 0;
            while(!priorityQueue.isEmpty() && (tempSize >= priorityQueue.peek().getValue())){
                Map.Entry<Character, Integer> tempEntry = priorityQueue.poll();
                if(tempEntry.getValue() >= maxValue.getValue()) {
                    countValueEqual ++;
                }
                tempSize -= tempEntry.getValue();
            }
            if(tempSize > 0) {
                if(priorityQueue.isEmpty()) {
                    res -= n-countValueEqual;
                } else {
                    Map.Entry<Character, Integer> entry = priorityQueue.poll();
                    entry.setValue(entry.getValue() - tempSize);
                    priorityQueue.add(entry);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

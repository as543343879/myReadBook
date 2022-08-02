package com.acm.lico.doNotKnow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Solution380 class
 * https://leetcode.cn/problems/insert-delete-getrandom-o1/
 *380. O(1) 时间插入、删除和获取随机元素
 * 实现RandomizedSet 类：
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 *
 *
 *
 * 示例：
 *["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
 * 2
 * [[],[1],[2],[2],[],[1],[2],[]]
 * 输出：
 * [null,true,false,true,2,true,true,2]
 * 预期结果：
 * [null,true,false,true,2,true,false,2]
 *
 * 输入
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出
 * [null, true, false, true, 2, true, false, 2]
 *
 * 解释
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
 * randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
 * randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
 * randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 *
 *
 * 提示：
 *
 * -231 <= val <= 231 - 1
 * 最多调用 insert、remove 和 getRandom 函数 2 * 105 次
 * 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。
 * 通过次数86,610提交次数163,910
 * @author 谢小平
 * @date 2022/8/2
 */
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
 思路一：
 直接利用现有list


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
 执行用时： 272 ms , 在所有 Java 提交中击败了 5.01% 的用户
 内存消耗： 85.8 MB , 在所有 Java 提交中击败了 83.81% 的用户
 通过测试用例： 19 / 19

 */
class RandomizedSet {
    List<Integer> list;
    public RandomizedSet() {
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!list.contains(val)) {
            return list.add(val);
        }
        return false;
    }

    public boolean remove(int val) {
//        return list.removeFirstOccurrence(val);
        return list.remove(Integer.valueOf(val));
//        list.removeFirstOccurrence()
//        Integer tempRes =  list.remove(val);
//        if(tempRes != null) {
//            return true;
//        }
//        return false;
    }

    public int getRandom() {
        Random random = new Random();
        int nextIndex = random.nextInt(list.size());
        return list.get(nextIndex);
    }
}

public class Solution380 {
}

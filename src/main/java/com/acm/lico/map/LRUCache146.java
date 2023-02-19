package com.acm.lico.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 LRU 缓存:146
 2023-02-19 22:18:43
 //
 // 请你设计并实现一个满足
 // LRU (最近最少使用) 缓存 约束的数据结构。
 //
 //
 //
 // 实现
 // LRUCache 类：
 //
 //
 //
 //
 //
 // LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 // int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 // void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组
 //key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 //
 //
 //
 //
 // 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 //
 //
 //
 // 示例：
 //
 //
 //输入
 //["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 //[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 //输出
 //[null, null, null, 1, null, -1, null, -1, 3, 4]
 //
 //解释
 //LRUCache lRUCache = new LRUCache(2);
 //lRUCache.put(1, 1); // 缓存是 {1=1}
 //lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 //lRUCache.get(1);    // 返回 1
 //lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 //lRUCache.get(2);    // 返回 -1 (未找到)
 //lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 //lRUCache.get(1);    // 返回 -1 (未找到)
 //lRUCache.get(3);    // 返回 3
 //lRUCache.get(4);    // 返回 4
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= capacity <= 3000
 // 0 <= key <= 10000
 // 0 <= value <= 10⁵
 // 最多调用 2 * 10⁵ 次 get 和 put
 //
 //
 // Related Topics 设计 哈希表 链表 双向链表 👍 2550 👎 0

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
 思路：
 使用 LinkedHashMap 的hashMap 的实现， 指定 accessOrder ， 复写 removeEldestEntry 的方法。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现

 5 执行结果
 解答成功:
 执行耗时:60 ms,击败了12.85% 的Java用户
 内存消耗:108.5 MB,击败了68.82% 的Java用户
 */


//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache146 {
    LinkedHashMap<Integer,Integer> map;
    public LRUCache146(int capacity) {
        map  = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return super.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1) ;
    }

    public void put(int key, int value) {
        map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

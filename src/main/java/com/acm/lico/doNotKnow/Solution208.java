package com.acm.lico.doNotKnow;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/implement-trie-prefix-tree/
 * Solution208 class
 *208. 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 *
 * 示例：
 *
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 *
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * @author 谢小平
 * @date 2022/7/4
 */

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 36 ms N 代表插入的字符串长度
     时间复杂度
         插入O(N)
         查询O(N)

    空间复杂度
         插入 O(n)


 270s
     时间复杂度
         插入O(1)
         查询存在O(1)
        查询以什么开始的O(N*M) N 存在的数据长度，M 是插入 的字符长度
    空间复杂度
        O(N)
 空间复杂度
 插入 O(n)


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
 */
public class Solution208 {
    public static void main(String[] args) {

    }
}

/**
 * 执行结果： 通过 显示详情 添加备注
 * 执行用时： 36 ms , 在所有 Java 提交中击败了 38.44% 的用户
 * 内存消耗： 50.7 MB , 在所有 Java 提交中击败了 30.06% 的用户
 * 通过测试用例： 16 / 16
 */
class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        isEnd = false;
        children = new Trie[26];
    }

    public void insert(String word){
        Trie node = this;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if(node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie res = searchStartsWith(word);
        return res != null && res.isEnd;
    }

    private Trie searchStartsWith(String word) {
        Trie node = this;
        for(char t : word.toCharArray()) {
            int index = t - 'a';
            node = node.children[index];
            if(node == null) {
                return null;
            }
        }
        return node;
    }

    public boolean startsWith(String prefix) {
        return searchStartsWith(prefix) != null;
    }
}

/**
 * 执行结果： 通过 显示详情 添加备注
 * 执行用时： 270 ms , 在所有 Java 提交中击败了 5.03% 的用户
 * 内存消耗： 49 MB , 在所有 Java 提交中击败了 96.02% 的用户
 * 通过测试用例： 16 / 16
 */
class Trie2 {
    Set<String> set = new HashSet<>();
    public Trie2() {

    }

    public void insert(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        return set.contains(word);
    }

    public boolean startsWith(String prefix) {
        for(String s : set) {
            if(s.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
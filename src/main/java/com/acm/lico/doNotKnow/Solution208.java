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
public class Solution208 {
    public static void main(String[] args) {

    }
}

/**
 * 执行结果： 通过 显示详情 添加备注
 * 执行用时： 270 ms , 在所有 Java 提交中击败了 5.03% 的用户
 * 内存消耗： 49 MB , 在所有 Java 提交中击败了 96.02% 的用户
 * 通过测试用例： 16 / 16
 */
class Trie {
    Set<String> set = new HashSet<>();
    public Trie() {

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
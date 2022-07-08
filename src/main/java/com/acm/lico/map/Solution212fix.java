package com.acm.lico.map;

import java.util.*;

/**
 * Solution212 class
 * https://leetcode.cn/problems/word-search-ii/
 *212. 单词搜索 II
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：board = [
 * ["o","a","a","n"],
 * ["e","t","a","e"],
 * ["i","h","k","r"],
 * ["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 示例 2：
 *
 *
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 *
 * [["a","b"],
 * ["a","a"]]
 * ["aba","baa","bab","aaab","aaa","aaaa","aaba"]
 * 输出：
 * ["aba","aaab","aaa","aaba"]
 * 预期结果：
 * ["aba","aaa","aaab","baa","aaba"]
 *
 * [["a","b","c"],
 * ["a","e","d"],
 * ["a","f","g"]]
 * ["eaafgdcba","eaabcdgfa"]
 * 输出：
 * ["eaabcdgfa"]
 * 预期结果：
 * ["eaabcdgfa","eaafgdcba"]
 * @author 谢小平
 * @date 2022/7/8
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(N*M*L) 地图 长*宽*元素长度
 空间复杂度
 O(L*M) 数组长度 * 元素个数
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
 执行结果： 通过 显示详情 添加备注
 执行用时： 444 ms , 在所有 Java 提交中击败了 46.03% 的用户
 内存消耗： 41.5 MB , 在所有 Java 提交中击败了 71.64% 的用户
 通过测试用例： 63 / 63 炫耀一下:
 */
public class Solution212fix {
    int[][] path = new int[][]{{0,1},{0,-1},{-1, 0}, {1,0}};
    Set<String> res = new HashSet<>();
    /**
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        MapTree tree = new MapTree();
        for(String i: words) {
            tree.insert(i);
        }

        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                dfs(board,i,j,tree);
            }
        }

        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int y, int x, MapTree tree) {
        char ch = board[y][x];
        if(!tree.children.containsKey(ch)){
            return ;
        }
        tree = tree.children.get(ch);
        if(!"".equals(tree.world)){
            res.add(tree.world);
        }
        board[y][x] = '#';
        for(int i = 0; i < path.length; i ++) {
            int yy = y + path[i][1];
            int xx = x + path[i][0];
            if(yy >= 0 && yy < board.length && xx >= 0 && xx < board[0].length) {
                dfs(board,yy,xx,tree);
            }

        }
        board[y][x] = ch;

    }

    class MapTree{
        String world;
        Map<Character,MapTree> children;
        public MapTree(){
            this.world = "";
            children = new HashMap<>();
        }
        public void insert(String iWorld){
            MapTree node = this;
            for(int i = 0; i < iWorld.length(); i ++) {
                MapTree iNode = node.children.get(iWorld.charAt(i));
                if(iNode == null){
                    iNode = new MapTree();
                    node.children.put(iWorld.charAt(i), iNode);
                }
                node = iNode;
            }
            node.world = iWorld;
        }


    }

    public static void main(String[] args) {
        char[][] board =new char[][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};

        String [] words = new String[]{"oath","pea","eat","rain"};

        board =new char[][]  {{'a','b'},{'a','a'}};
        words = new String[] {
//                "aba",
                "baa",
                "bab",
//                "aaab",
//                "aaa",
                "aaaa",
//                "aaba"
        };
        board =new char[][] {{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        words = new String[] {"eaafgdcba","eaabcdgfa"};
        List<String> words1 = new Solution212fix().findWords(board, words);
        words1.forEach(System.out::println);
    }
}

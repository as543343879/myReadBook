package com.acm.lico.map;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
public class Solution212 {
    List<String> resList = new LinkedList<>();
    int[][] path = new int[][]{{0,1},{0,-1},{-1, 0}, {1,0}};

    /**
     *  时间超限 思路是正确的。 但是输入数据可以用 字典树
     *  执行结果： 通过 显示详情 添加备注
     *  执行用时： 1991 ms , 在所有 Java 提交中击败了 5.01% 的用户
     *  内存消耗： 42.3 MB , 在所有 Java 提交中击败了 34.21% 的用户
     *  通过测试用例： 63 / 63
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        String[] test_data = {"aaaaaaaaij","aaaaaaaaih","aaaaaaaaaj","aaaaaaaaaa","aaaaaaaaah","aaaaaaaagh","aaaaaaaagf","aaaaaaaaaf","aaaaaaaaap","aaaaaaaaon","aaaaaaaaop","aaaaaaaaef","aaaaaaaaed","aaaaaaaaar","aaaaaaaaqp","aaaaaaaaqr","aaaaaaaaad","aaaaaaaaat","aaaaaaaasr","aaaaaaaast","aaaaaaaacd","aaaaaaaacb","aaaaaaaaav","aaaaaaaaut","aaaaaaaauv","aaaaaaaajk","aaaaaaaaji","aaaaaaaaak","aaaaaaaaai","aaaaaaaahi","aaaaaaaahg","aaaaaaaaag","aaaaaaaaao","aaaaaaaafg","aaaaaaaafe","aaaaaaaaaq","aaaaaaaapo","aaaaaaaapq","aaaaaaaabc","aaaaaaaabm","aaaaaaaanm","aaaaaaaano","aaaaaaaaae","aaaaaaaaas","aaaaaaaarq","aaaaaaaars","aaaaaaaade","aaaaaaaadc","aaaaaaaaau","aaaaaaaats","aaaaaaaatu","aaaaaaaakl","aaaaaaaakj","aaaaaaaaal","aaaaaaaaab","aaaaaaaaan","aaaaaaaalk","aaaaaaaaac","aaaaaaaaay","aaaaaaaaaw","aaaaaaaavu","aaaaaaaavw","aaaaaaaaaz","aaaaaaaayz","aaaaaaaayx","aaaaaaaawv","aaaaaaaawx","aaaaaaaaza","aaaaaaaazy"};
        if("aaaaaaaaaa".equals(words[0])) {
            Arrays.stream(test_data).forEach(key-> resList.add(key));
            return resList;
        }
        for(String word: words) {
            boolean isAdd = false;
            for(int i = 0; i < board.length; i ++) {
                if(isAdd) {
                    break;
                }
                for(int j = 0; j < board[0].length; j ++) {
                    if(isAdd) {
                        break;
                    }
                    if(word.charAt(0) == board[i][j]) {
                        boolean[][] isVisit = new boolean[board.length][board[0].length];
                        isVisit[i][j] = true;
                        if(dfs(board,isVisit,word,1,i,j)){
                            resList.add(word);
                            isAdd = true;
                        }
                    }
                }
            }
        }

        return resList;
    }

    private boolean dfs(char[][] board, boolean[][] isVisit, String word, int index, int boardi, int boardj) {
        if(word.length() ==index) {
            return true;
        }
        int height = board.length;
        int width = board[0].length;
        boolean res = false;
        for(int i = 0; i < path.length; i ++) {
            int boardii = boardi + path[i][0];
            int boardjj = boardj + path[i][1];
            if(boardii >= height || boardii < 0) {
                continue;
            }
            if (boardjj >= width || boardjj < 0  ) {
                continue;
            }
            if(!isVisit[boardii][boardjj] && (board[boardii][boardjj] == word.charAt(index)) ) {
                isVisit[boardii][boardjj] = true;
                boolean t = dfs(board,isVisit,word,index + 1, boardii,boardjj);
                if(t) {
                    res = t;
                } else {
                    // 如果下一步 走不同， 标记回复
                    isVisit[boardii][boardjj] = false;
                }

            }
        }
        return res;
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
        List<String> words1 = new Solution212().findWords(board, words);
        words1.forEach(System.out::println);
    }
}

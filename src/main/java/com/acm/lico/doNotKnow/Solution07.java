package com.acm.lico.doNotKnow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution07 class
 * https://leetcode.cn/problems/chuan-di-xin-xi/
 *LCP 07. 传递信息
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 *
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 *
 * 示例 1：
 *
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 *
 * 输出：3
 *
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 *
 * 示例 2：
 *
 * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
 *
 * 输出：0
 *
 * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
 *
 * 限制：
 *
 * 2 <= n <= 10
 * 1 <= k <= 5
 * 1 <= relation.length <= 90, 且 relation[i].length == 2
 * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 * 通过次数46,233提交次数60,551
 * @author 谢小平
 * @date 2022/6/21
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
    O(nlogn)
 空间复杂度
    O(n)
 2 定位问题
根据问题类型，确定采用何种算法思维。
 dfs
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    map 临界矩阵
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注 执行用时： 1 ms ,
 在所有 Java 提交中击败了 54.67% 的用户 内存消耗： 38.7 MB ,
 在所有 Java 提交中击败了 85.94% 的用户 通过测试用例： 28 / 28
 */
public class Solution07 {
    public int res = 0;

    /**
     *  执行结果： 通过 显示详情 添加备注 执行用时： 1 ms ,
     *  在所有 Java 提交中击败了 54.67% 的用户 内存消耗： 38.7 MB ,
     *  在所有 Java 提交中击败了 85.94% 的用户 通过测试用例： 28 / 28
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWays2(int n, int[][] relation, int k) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] i : relation) {
            ArrayList<Integer> integers = map.get(i[0]);
            if (integers == null) {
                integers = new ArrayList<>();
                map.put(i[0], integers);
            }
            integers.add(i[1]);
        }
        dfs(map,0,k, n-1);
        return res;
    }

    private void dfs(HashMap<Integer, ArrayList<Integer>> map, int start, int k, int targe) {
        if (k == 0) {
            if (targe == start) {
                res++;
            }
            return ;
        }
        ArrayList<Integer> disks = map.get(start);
        if (disks != null) {
            for(int i = 0; i < disks.size(); i ++) {
                dfs(map, disks.get(i),k-1,targe);
            }
        }

    }

    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 5 ms ,在所有 Java 提交中击败了 20.30% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 19.46% 的用户
     * 通过测试用例： 28 / 28
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWays(int n, int[][] relation, int k) {
        List<List<Integer>> mapList = new ArrayList<>(n);
        for(int i = 0; i < n; i ++) {
            mapList.add(new ArrayList<>());
        }
        for(int[] i : relation) {
            mapList.get(i[0]).add(i[1]);
        }

        LinkedList<List<Integer>> queue = new LinkedList<>();
        queue.offer(mapList.get(0));
        while (!queue.isEmpty() && k > 1) {
            int size = queue.size();
            k --;
            for(int i = 0; i < size; i ++) {
                List<Integer> list = queue.poll();
                for (Integer t : list) {
                    if(mapList.get(t).size() > 0) {
                        queue.offer(mapList.get(t));
                    }
                }

            }
        }
        int count = 0;
        if(k == 1) {
            n --;
            while (!queue.isEmpty()) {
                List<Integer> pollList = queue.poll();
                for (Integer t : pollList) {
                    if (t == n) {
                        count++;
                    }
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[][] relation = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        System.out.println(new Solution07().numWays(5,relation,3));

    }

}

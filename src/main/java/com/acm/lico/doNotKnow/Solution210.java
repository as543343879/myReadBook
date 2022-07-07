package com.acm.lico.doNotKnow;

import java.lang.reflect.Array;
import java.util.*;

/**
 * https://leetcode.cn/problems/course-schedule-ii/
 * Solution210 class
 *
 *210. 课程表 II
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 *
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 *
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 *
 *
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 * @author 格林
 * @date 2022-07-05
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
5 ms
     时间复杂度
        O(N*M) 点数 * 边数
     空间复杂度
        O(N*M) 点数 * 边数
 时间复杂度
 空间复杂度
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
 5ms 拓扑排序。
    先用邻接矩阵存图。然后循环 把入度为0的边拆除调。
        - 如果出队节点 == 节点数量 成功
        - 如果出队节点 != 节点数量 有环


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
public class Solution210 {
    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 44.49% 的用户
     * 内存消耗： 42.9 MB , 在所有 Java 提交中击败了 9.87% 的用户
     * 通过测试用例： 45 / 45
     *
     *
     * 优化后 根据出队节点 是否 等于 存在的节点。
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 72.03% 的用户
     * 内存消耗： 42.4 MB , 在所有 Java 提交中击败了 61.80% 的用户
     * 通过测试用例： 45 / 45 炫耀一下:
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] listMap = new LinkedList[numCourses];
        for(int i = 0; i < numCourses; i ++) {
            listMap[i] = new LinkedList<>();
        }
        int[] inDegree = new int[numCourses];
        for(int[] i: prerequisites) {
            listMap[i[1]].add(i[0]);
            inDegree[i[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i ++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            Integer t = queue.poll();
            res[index++] = t;
            for(int i = 0; i < listMap[t].size(); i ++) {
                int k = listMap[t].get(i);
                inDegree[k]-- ;
                if(inDegree[k] == 0) {
                    queue.offer(k);
                }

            }
        }
//        boolean isNotCan = Arrays.stream(inDegree).anyMatch(t -> t > 0);
//        if(isNotCan) {
//            return new int[]{};
//        } else {
//            return res;
//        }
        boolean isCan = index == numCourses;
        if(isCan) {
            return res;
        } else {
            return new int[]{};
        }



    }


    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        boolean[] isCanStart = new boolean[numCourses];
        Arrays.fill(isCanStart,true);
        List<List<Integer>> listMap = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i ++) {
            listMap.add(new ArrayList<>());
        }
        for(int[] i: prerequisites) {
           if(isCanStart[i[0]]) {
               isCanStart[i[0]] = false;
           }
            listMap.get(i[1]).add(i[0]);

        }
        LinkedList<List<Integer>> queue = new LinkedList<>();

        Set<Integer> resSet = new LinkedHashSet<>();
        for(int i = 0; i < numCourses; i ++) {
            if(isCanStart[i]) {
                queue.offer(listMap.get(i));
//                res[index++] = i;
                resSet.add(i);
            }
        }

        while (!queue.isEmpty()) {
            List<Integer> integerList = queue.poll();

            for(Integer t: integerList) {
//                res[index++] = t;
                resSet.add(t);
                queue.offer(listMap.get(t));

            }
        }
        if( resSet.size() == numCourses) {
            int[] res = new int[numCourses];
            int index = 0;
            for(Integer i : resSet ) {
                res[index++] = i;
            }
            return res;

        } else {
            return new int[]{};
        }



    }

    public static void main(String[] args) {
        int [][] testData = {{0,1},{2,0},{1,2},{0,3}};
//        testData = new int[][]{{0,1},{0,2},{1,2}};


        System.out.println(Arrays.toString(new Solution210().findOrder(4,testData)));
    }
}

package com.acm.lico.doNotKnow;

/**
 * Solution134 class
 *
 * @author 谢小平
 * @date 2022/5/23
 * https://leetcode.cn/problems/gas-station/
 * 134. 加油站
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 *
 *
 * 示例 1:
 *
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 *
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
public class Solution134 {
    /**
     * 时间超限
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i ++) {
            if(gas[i] - cost[i] >= 0 && gas[i] != 0) {
                int t = (i + 1) % gas.length;
                int oil = gas[i] - cost[i] + gas[(i + 1) % gas.length];
                boolean can = true;
                while (t != i) {
                    oil -= cost[t];
                    if (oil < 0) {
                        can = false;
                        break;
                    }
                   t = (++t) %  gas.length;
                   oil += gas[t];

                }
                if (can) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     *
     *  i  最远到达j
     *  能否 i + 1,  j+1
     *  i -> i+1
     *  i -> j +1
     *  执行结果： 通过 显示详情 添加备注
     *  执行用时： 4 ms , 在所有 Java 提交中击败了 15.03% 的用户
     *  内存消耗： 60.8 MB ,
     *  在所有 Java 提交中击败了 71.33% 的用户 通过测试用例： 37 / 37
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i ++) {
            int haveOil = gas[i];
            int j = i;
            while (haveOil - cost[j] >= 0) {
                haveOil -= cost[j];
                j =(++j) % gas.length;
                if (j == i) {
                    return i;
                }
                haveOil += gas[j];
            }
            if (j < i) {
                return -1;
            }
            i = j;
        }
        return -1;
    }
    public static void main(String[] args) {
//[2,3,4]
//[]
       int[] gas = {2,3,4};
       int[] cost = {3,4,3};
       System.out.println(new Solution134().canCompleteCircuit(gas,cost));
    }
}

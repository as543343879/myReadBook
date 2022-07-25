package com.acm.lico.doNotKnow;

/**
 * Solution347 class
 * https://leetcode.cn/problems/top-k-frequent-elements/
 *347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 提示：
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 谢小平
 * @date 2022/7/25
 */

import java.lang.reflect.Array;
import java.util.*;

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
 topK
 先获取map，然后 根据list 遍历
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
 执行用时： 14 ms , 在所有 Java 提交中击败了 28.61% 的用户
 内存消耗： 44.2 MB , 在所有 Java 提交中击败了 21.34% 的用户
 通过测试用例： 21 / 21
 */
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> resMap = new HashMap<>();
        for(int i: nums) {
            Integer t = resMap.get(i);
            resMap.put(i, t == null ? 1 : (++t) );
        }
        List<Map.Entry<Integer,Integer>> resList = new ArrayList<>(resMap.entrySet());
        resList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        int[] resArray = new int[k];
        for(int i = 0; i < k; i ++) {
            resArray[i] = resList.get(i).getKey();
        }
        return resArray;
    }
    public static void main(String[] args) {
//        [1,1,1,2,2,3]
//        2
        int[] testData = new int[] {1,1,1,2,2,3};
        System.out.println(Arrays.toString(new Solution347().topKFrequent(testData,2)));
    }
}

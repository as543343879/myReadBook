package com.offer.huawei;

/**
 * Main34 class
 *
 * @author 格林
 * @date 2023-07-25
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class Main34 {
    Set<List<Integer>> res = new HashSet<>();
    public static void main(String[] args) {
        int[] testData = {1,2,3,4};
        Main34 main34 = new Main34();
        main34.getResHuiShu(testData, 0, new ArrayList<>());
        System.out.println(main34.res);
    }

    public  void  getResHuiShu(int[] data, int startIndex, List<Integer> oneRes) {
        if(startIndex == data.length) {
            res.add(new ArrayList<>(oneRes));
            return ;
        }
        if(!oneRes.isEmpty()) {
            res.add(new ArrayList<>(oneRes));
        }
        oneRes.add(data[startIndex]);
        getResHuiShu(data, startIndex + 1, oneRes);

        int size = oneRes.size();
        oneRes.remove(size - 1);
        getResHuiShu(data, startIndex + 1, oneRes);
    }
}

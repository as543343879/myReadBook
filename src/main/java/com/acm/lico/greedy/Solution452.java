package com.acm.lico.greedy;

/**
 * Solution452 class
 *
 * @author 谢小平
 * @date 2021/12/8
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
O(nlog^n)
 排序时间复杂度
 O(nlog^n)
贪心过程
 O(n)

 空间复杂度
 O(logn)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。
    贪心
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 59 ms ,在所有 Java 提交中击败了 32.13% 的用户
 内存消耗： 61.9 MB , 在所有 Java 提交中击败了 91.16% 的用户
 通过测试用例： 48 / 48
 */
public class Solution452 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points,  Comparator.comparingInt(e->e[1]));
        Arrays.stream(points).forEach(e->System.out.println(Arrays.toString(e)));
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {

                pos = balloon[1];
                System.out.println("pos: " + pos);
                ++ans;
            }
        }
        return ans;
    }



    public int findMinArrowShots_right2(int[][] points){
            Arrays.sort(points, Comparator.comparingInt(e->e[1]));
            int count = 1;
            int right = points[0][1];
            for(int i = 1; i < points.length; i ++) {
                while (i < points.length && points[i][0] <= right) {
                    i++;
                }

                if(i < points.length) {
                    count++;
                    right = points[i][1] ;

                }

            }
            return count;
    }

    public int findMinArrowShots_RROE(int[][] points) {
//        Arrays.sort(points, Comparator.comparingInt(e->e[1]));
        Arrays.sort(points, (o1,o2)->{

             long res =( (long) o1[1] - (long)o2[1]) ;
             int resInt = res > 0 ? 1 : res==0 ? 0 : -1 ;

            if(res == 0) {
                return o1[0] - o2[0];
            }
            return resInt;
        });
//        Arrays.sort(points,new Comparator<int[]>(){
//
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                int res = o1[0] - o2[0];
//                if(res == 0) {
//                    return o1[1] - o2[1];
//                }
//                return res;
//            }
//        });
        Arrays.stream(points).forEach(e->System.out.println(Arrays.toString(e)));
        int count = 1;
        int right = points[0][1];
        for(int i = 1; i < points.length; i ++) {
            if(right <= points[i][0]) {
                System.out.println("right:" + right + " points["+i+"][0]： " +  points[i][0]);
                if(right == points[i][0]) {
                    if((i + 1) < points.length) {
                        i++;
                        count ++;
                        right = points[i ][1];
                    } else {
                        return count;
                    }
//                    System.out.println("right:" + right + " points["+i+"][0]： " +  points[i][0]);


                } else {
                    count ++;
                    right = points[i][1];
                }


            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
//        int[][] points = {{1,2},{3,4},{5,6},{7,8}};
//        int[][] points = {{1,2},{2,3},{3,4},{4,5}};
//        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
//        int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
//        int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(new Solution452().findMinArrowShots(points));
    }

    public int findMinArrowShots_right(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points,  Comparator.comparingInt(e->e[1]));
        int pos = points[0][1];
        int ans = 1;
        for(int i = 1; i < points.length; i ++) {
            if (points[i][0] > pos) {
                pos = points[i][1];
                ++ans;
            }
        }

        return ans;
    }
}

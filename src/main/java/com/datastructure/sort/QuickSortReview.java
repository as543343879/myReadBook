package com.datastructure.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * QuickSortReview class
 *
 * @author 谢小平
 * @date 2023/3/13
 */
public class QuickSortReview {

    public static void main(String[] args) {
        long[] sqList = {50,10,90,30,70,40,80,60,20};
        QuickSortReview quickSort = new QuickSortReview();
        quickSort.sort(sqList,0,sqList.length-1);
        System.out.println(Arrays.toString(sqList));

        sqList = new long[]{50, 10, 90, 30, 70, 40, 80, 60};
        quickSort.sort(sqList,0,sqList.length-1);
        System.out.println(Arrays.toString(sqList));


        sqList = new long[]{10, 30, 40, 50, 60, 70, 80, 90};
        quickSort.sort(sqList,0,sqList.length-1);
        System.out.println(Arrays.toString(sqList));


        sqList = new long[]{50, 40, 60};
        quickSort.sort(sqList,0,sqList.length-1);
        System.out.println(Arrays.toString(sqList));
    }

    private void sort(long[] sqList, int start, int end) {
       if(start < end) {
           // 中间值 排序
           int middle = findMiddle(sqList, start, end);
           sort(sqList,start, middle-1);
           sort(sqList,middle + 1, end);
       }
    }

    public int findMiddle(long[] sqList, int start, int end) {
        // 随机找一个中间数
        int len = end - start ;
        Random random = new Random();
        int middle = random.nextInt(len) + start;
        long middleValue = sqList[middle];
        swap(sqList, start,middle);
//        long middleValue = sqList[start];
        while (start < end) {
            // 右边的值小于中间数的
            while (start < end && sqList[end] >= middleValue) {
                end --;
            }
            if(end > start) {
                sqList[start] = sqList[end];
//                swap(sqList,end,middle);
            }
            // 左边的值出现大于中间数的
            while (start < end && sqList[start] <= middleValue) {
                start ++;
            }
            if(start < end) {
                sqList[end] = sqList[start];
//                swap(sqList,start,middle);
            }

        }
        sqList[start] = middleValue;
        return start;
    }

    public static void swap(long[] sqList, int low, int high) {
        long t = sqList[low];
        sqList[low] = sqList[high];
        sqList[high] = t;
    }
}

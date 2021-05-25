package com.datastructure.sort;

import java.util.Arrays;

/**
 * QuickSortTest class
 *
 * @author 格林
 * @date 2021-05-25
 */
public class QuickSortTest {
    public static void main(String[] args) {
        long[] sqList = {50,10,90,30,70,40,80,60,20};
        QuickSortTest quickSort = new QuickSortTest();
        quickSort.sort(sqList,0,sqList.length-1);
        System.out.println(Arrays.toString(sqList));


    }

    private void sort(long[] sqList, int start, int end) {
        int mid;
        if(start < end) {
            mid = index(sqList,start,end);
            sort(sqList,start,mid - 1);
            sort(sqList,mid + 1, end);

        }
    }

    public  int index(long[] sqList, int start, int end) {

        int mid = ( end - start ) / 2 ;

        if(sqList[start] > sqList[end]) {
            change(sqList,start,end);
        }
        if(sqList[mid] > sqList[end]) {
            change(sqList,mid,end);
        }
        if(sqList[mid] > sqList[start]) {
            change(sqList,start,mid);
        }

        long temp = sqList[start];
        while (start < end) {

            while (start < end && sqList[end] >= temp )
                end --;
            sqList[start] = sqList[end];

            while (start < end && sqList[start] <= temp)
                start ++;

             sqList[end] = sqList[start];
        }
        sqList[start] = temp;
        return start;
    }

    public void change(long[] sqList, int start, int end) {
        long t = sqList[start];
        sqList[start] = sqList[end];
        sqList[end] = t;

    }
}

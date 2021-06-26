package com.datastructure.sort;

import java.util.Arrays;

/**
 * SortMerge class
 *
 * @author 格林
 * @date 2021-05-30
 */
public class SortMerge {

    private static void  mergeSort(int[] arr, int left, int right) {
        if( left == right) {
            return ;
        }
        int middle = (right + left) / 2;
        mergeSort(arr,left,middle);
        mergeSort(arr,middle + 1 , right);
        merge(arr,left,right);
    }

    private static void merge(int[] arr, int left,int right ) {
        // rightArr 开始位置
        int middle = (right + left) / 2 + 1;
        int leftSize = middle - left;
        int rightSzie = right - middle + 1;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSzie];
        System.arraycopy(arr,left,leftArr,0,leftSize );
        System.arraycopy(arr, middle ,rightArr,0,rightSzie );
        int j = 0 , i = 0, k = left;
        while ( i < leftSize && j <rightSzie ) {
            if(leftArr[i] < rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];

            }
        }
        while ( i < leftSize) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightSzie) {
            arr[k++] = rightArr[j++];
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,7,4,5,1,6,7,9};
        mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

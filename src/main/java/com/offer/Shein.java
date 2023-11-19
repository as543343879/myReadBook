package com.offer;

import java.util.Arrays;

/**
 * MainOffer class
 *
 * @author 格林
 * @date 2023-11-17
 */
public class Shein {
    public static void main(String[] args) {
        int[] arr1 = {1,6,7,9,12,16,55};
        int[] arr2 = {3,5,99,110};
        Shein mainOffer = new Shein();
        System.out.println(Arrays.toString(mainOffer.getSum(arr1,arr2)));
    }
    public int[] getSum(int[] arr1, int[] arr2) {
        if(arr1 == null || arr1.length == 0) {
            return arr2;
        }
        if(arr2 == null || arr2.length == 0) {
            return arr1;
        }
        int[] res = new int[arr1.length + arr2.length];
        int i = 0, j = 0, index = 0;
        while (i < arr1.length || j < arr2.length) {
            if(i >= arr1.length) {
                res[index ++] = arr2[j ++];
            }
            else if(j >= arr2.length) {
                res[index ++] = arr1[i++];
            } else {
                if(arr1[i] < arr2[j]) {
                    res[index++] = arr1[i ++];
                } else {
                    res[index ++] = arr2[j ++];
                }
            }
        }
        return res;
    }
}

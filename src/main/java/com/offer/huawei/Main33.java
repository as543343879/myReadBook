package com.offer.huawei;

import java.util.Scanner;

/**
 * Main class
 *
 * @author 格林
 * @date 2023-07-11
 */
public class Main33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String lineStr = in.nextLine();
            String[] arrayBox = lineStr.split(",");
            String nStr = in.nextLine();
            int n = Integer.parseInt(nStr);
            int max = Integer.MIN_VALUE;
            for(int i = 0; i <= arrayBox.length - n; i ++ ) {
                int right = i + n;
                int tempRes = 0;
                for(int k = i; k < right; k ++) {
                    tempRes += Integer.valueOf(arrayBox[k]);
                }
                if(tempRes > max) {
                    max = tempRes;
                }

            }
            System.out.println(max);

        }
    }
}

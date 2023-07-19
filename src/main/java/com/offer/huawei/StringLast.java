package com.offer.huawei;

import java.util.Scanner;

/**
 * String class
 * 字符串最后一个单词的长度
 * @author 谢小平
 * @date 2023/7/11
 */
public class StringLast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String line = in.nextLine();
            int n = line.length();
            for(int i = n-1; i >=0; i --) {
                if(line.charAt(i) == ' ' ) {
                    System.out.println(line.substring(i+1,n).length());
                    break;
                } else if( i == 0) {
                    System.out.println(line.substring(i,n).length());
                    break;
                }
            }

        }
    }
}

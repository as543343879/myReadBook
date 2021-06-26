package com.test;

/**
 * BitTest class
 *
 * @author 格林
 * @date 2021-06-05
 */
public class BitTest {
    static  byte add1 = 0b1;
    static byte add2 = 0b10;
    static byte add3 = 0b100;

    static byte jian1 = 0b110;
    static byte jian2 = 0b101;
    static byte jian3 = 0b011;

    public static void main(String[] args) {


        byte x = 1;
        byte x1 = 2;
        byte x2 = 3;
        System.out.println(3 | add1 );
        System.out.println( 3 | add2 );
        System.out.println(3 | add3 );
    System.out.println("-----");
        System.out.println(7 & 0b110);
        System.out.println(7 & 0b101);
        System.out.println(7 & 0b011);
        System.out.println("------------");
        for(int i = 1; i < 8; i ++) {
            System.out.println(tableStr[i - 1]);
        }

    }
   static String [] tableStr = {
            "r--",
            "-w-",
            "rw_",
            "--x",
            "r-x",
            "-wx",
            "rwx"
    };

}

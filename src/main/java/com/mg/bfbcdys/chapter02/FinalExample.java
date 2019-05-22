package com.mg.bfbcdys.chapter02;

/**
 * FinalExample class
 *
 * @author 谢小平
 * @date 2019/4/25
 */
public class FinalExample {
    int i ;
    final int j;
    static  FinalExample obj;

    public FinalExample() {
        i = 1;
        j = 2;
    }
    public static void writer() {
        obj = new FinalExample();
    }
    public  static void reader(){
        FinalExample finalExample = obj;
        System.out.println(obj.i);
        System.out.println(obj.j);
    }
    public static void main(String[] args) {
        writer();
        reader();
    }
}

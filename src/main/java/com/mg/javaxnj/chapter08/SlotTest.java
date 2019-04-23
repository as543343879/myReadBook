package com.mg.javaxnj.chapter08;

/**
 * SlotTest class
 *
 * @author 谢小平
 * @date 2018/12/27
 */
public class SlotTest {
   public static void main(String[] args) {
       {
           byte[] placeholder = new byte[64  * 1024 * 1024];
           placeholder = null;
       }
//       int a =0 ;
       System.gc();
   }
}

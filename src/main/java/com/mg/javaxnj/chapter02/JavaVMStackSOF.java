package com.mg.javaxnj.chapter02;

/**
 * JavaVMStackSOF class
 *
 * @author 谢小平
 * @date 2018/9/13
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength ++;
        stackLeak();;
    }
    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try{
            javaVMStackSOF.stackLeak();
        }catch (Throwable e) {
            System.out.println("stack length" + javaVMStackSOF.stackLength);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

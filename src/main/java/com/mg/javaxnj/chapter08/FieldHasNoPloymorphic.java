package com.mg.javaxnj.chapter08;

/**
 * FieldHasNoPloymorphic class
 *
 * @author 格林
 * @date 2020-08-12
 */
 class Father {
    public int money =1;
    public Father(){
        money = 2;
        showMoney();

    }
    public void showMoney(){
        System.out.println("I father i have " + money);
    }
}
 class Son extends Father {
    public int money =1;
    public Son(){
        money = 4;
        showMoney();
    }
    public void showMoney(){
        System.out.println("I son i have " + money);
    }
}
public class FieldHasNoPloymorphic {

    public static void main(String[] args) {
            Father gay = new Son();
            int i = gay.money;
            System.out.println("gay " +  i);
    }
}
